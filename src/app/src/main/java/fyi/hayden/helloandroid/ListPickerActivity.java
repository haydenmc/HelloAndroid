package fyi.hayden.helloandroid;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import fyi.hayden.helloandroid.models.ListModel;

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
        ListModelAdapter adapter = new ListModelAdapter(viewModel.getTodoLists().getValue(),
            item -> listSelected(item));
        viewModel.getTodoLists().observe(this, todoListList ->
        {
            adapter.setData(todoListList);
        });
        listRecyclerView.setAdapter(adapter);
        listRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void listSelected(ListModel list)
    {
        Toast.makeText(getApplicationContext(), "'" + list.getName() + "' clicked", Toast.LENGTH_SHORT).show();
    }
}
