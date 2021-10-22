package fyi.hayden.helloandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class ListViewerActivity extends AppCompatActivity
{
    private RecyclerView todoItemsRecyclerView;
    private String listItems[] = { "Test Item One", "Test Item Two", "Test Item Three" };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_viewer);
        todoItemsRecyclerView = findViewById(R.id.list_todo_items);
        ListItemAdapter adapter = new ListItemAdapter(listItems);
        todoItemsRecyclerView.setAdapter(adapter);
        todoItemsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Intent navBarUpdate = new Intent("android.intent.action.CHANGE_NAV_BAR");
        navBarUpdate.putExtra("left", "LEFT");
        navBarUpdate.putExtra("center", "CENTER");
        navBarUpdate.putExtra("right", "RIGHT");
        navBarUpdate.putExtra("clear_overlays", true);
        sendBroadcast(navBarUpdate);
    }
}