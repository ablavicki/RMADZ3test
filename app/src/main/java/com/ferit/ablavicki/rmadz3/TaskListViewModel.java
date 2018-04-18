package com.ferit.ablavicki.rmadz3;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class TaskListViewModel extends ViewModel {

    TaskRepository mRepository;

    public TaskListViewModel(){
        mRepository = TaskRepository.getInstance();
    }

    public void deleteTask(Task task) {
        mRepository.deleteTask(task);
    }

    public LiveData<List<Task>> getTaskList() {
        return mRepository.getTasks();
    }

    public void insertTask(){
        mRepository.insertTask();
    }
}
