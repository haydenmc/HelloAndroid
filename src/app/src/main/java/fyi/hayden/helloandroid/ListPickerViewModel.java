package fyi.hayden.helloandroid;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import fyi.hayden.helloandroid.models.ListModel;

public class ListPickerViewModel extends ViewModel
{
    private MutableLiveData<List<ListModel>> todoLists;

    public ListPickerViewModel()
    {
        todoLists = new MutableLiveData<List<ListModel>>();
        List<ListModel> items = new ArrayList<>();
        items.add(new ListModel("List One"));
        items.add(new ListModel("List Two"));
        items.add(new ListModel("List Three"));
        todoLists.setValue(items);
    }

    public LiveData<List<ListModel>> getTodoLists()
    {
        return todoLists;
    }
}
