package fyi.hayden.helloandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoItemAdapter extends RecyclerView.Adapter<TodoItemAdapter.ViewHolder>
{
    private String[] dataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView textView;

        public ViewHolder(View view)
        {
            super(view);
            textView = view.findViewById(R.id.body_text);
        }

        public TextView getTextView()
        {
            return textView;
        }
    }

    public TodoItemAdapter(String[] dataSet)
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
