package com.ferit.ablavicki.rmadz3;

import android.arch.lifecycle.ViewModel;

public class TaskListViewModel extends ViewModel {
    TaskRepository mRepository;

    public TaskListViewModel(){
        mRepository = TaskRepository.getInstance();
    }
}
