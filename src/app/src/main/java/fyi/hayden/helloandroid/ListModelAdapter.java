package fyi.hayden.helloandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fyi.hayden.helloandroid.models.ListModel;

public class ListModelAdapter extends RecyclerView.Adapter<ListModelAdapter.ViewHolder>
{
    private List<ListModel> dataSet;
    private OnItemClickListener listener;

    public interface OnItemClickListener
    {
        void onItemClick(ListModel item);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView titleTextView;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.text_title);
        }

        public TextView getTitleTextView()
        {
            return titleTextView;
        }
    }

    public ListModelAdapter(List<ListModel> dataSet, OnItemClickListener listener)
    {
        this.dataSet = dataSet;
        this.listener = listener;
    }

    public void setData(List<ListModel> dataSet)
    {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.todo_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        ListModel listModel = dataSet.get(position);
        holder.getTitleTextView().setText(listModel.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                listener.onItemClick(listModel);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return dataSet.size();
    }
}
