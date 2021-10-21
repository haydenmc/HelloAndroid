package fyi.hayden.helloandroid;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import fyi.hayden.helloandroid.models.TodoList;

public class ListPickerViewModel extends ViewModel
{
    private MutableLiveData<List<TodoList>> todoLists;

    public ListPickerViewModel()
    {
        todoLists = new MutableLiveData<List<TodoList>>();
        List<TodoList> items = new ArrayList<>();
        items.add(new TodoList("List One"));
        items.add(new TodoList("List Two"));
        items.add(new TodoList("List Three"));
        todoLists.setValue(items);
    }

    public LiveData<List<TodoList>> getTodoLists()
    {
        return todoLists;
    }
}
