package fyi.hayden.helloandroid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fyi.hayden.helloandroid.models.TodoList;

public class ListPickerActivity extends AppCompatActivity
{
    private ListPickerViewModel viewModel;
    private RecyclerView listRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_picker);
        viewModel = new ViewModelProvider(this).get(ListPickerViewModel.class);
        listRecyclerView = findViewById(R.id.list_list);
        TodoListAdapter adapter = new TodoListAdapter(viewModel.getTodoLists().getValue());
        viewModel.getTodoLists().observe(this, todoListList ->
        {
            adapter.setData(todoListList);
        });
        listRecyclerView.setAdapter(adapter);
        listRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
