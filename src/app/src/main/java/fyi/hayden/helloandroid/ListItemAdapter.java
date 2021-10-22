package fyi.hayden.helloandroid;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ViewHolder>
{
    private String[] dataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView textView;

        public ViewHolder(View view)
        {
            super(view);
            textView = view.findViewById(R.id.body_text);
            view.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Log.d("TodoItemAdapter", "Element " + getAdapterPosition() + " clicked.");
                }
            });
        }

        public TextView getTextView()
        {
            return textView;
        }
    }

    public ListItemAdapter(String[] dataSet)
    {
        this.dataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.todo_list_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.getTextView().setText(dataSet[position]);
    }

    @Override
    public int getItemCount()
    {
        return dataSet.length;
    }
}
