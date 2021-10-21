package fyi.hayden.helloandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fyi.hayden.helloandroid.models.TodoList;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.ViewHolder>
{
    private List<TodoList> dataSet;

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

    public TodoListAdapter(List<TodoList> dataSet)
    {
        this.dataSet = dataSet;
    }

    public void setData(List<TodoList> dataSet)
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
        TodoList listModel = dataSet.get(position);
        holder.getTitleTextView().setText(listModel.getName());
    }

    @Override
    public int getItemCount()
    {
        return dataSet.size();
    }
}
