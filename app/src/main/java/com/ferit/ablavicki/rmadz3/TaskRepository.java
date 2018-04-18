package com.ferit.ablavicki.rmadz3;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class TaskRepository {

    private static TaskRepository sInstance;

    private TaskDatabase mDatabase;
    private LiveData<List<Task>> mData;

    private TaskRepository(Application application){
        mDatabase = TaskDatabase.getInstance(application);
        mData = mDatabase.taskDao().getTasks();
    }

    public static TaskRepository getInstance(){
        if(sInstance == null){
            sInstance = new TaskRepository(ToDoApp.getInstance());
        }
        return sInstance;
    }

    public LiveData<List<Task>> getTasks() {
        return mData;
    }

    public void insertTask(){
        Task task = TaskGenerator.generate();
        new insertTaskAsync(mDatabase.taskDao()).execute(task);
    }

    public void deleteTask(Task task){
        new deleteTask(mDatabase.taskDao()).execute(task);
    }

    private class insertTaskAsync extends AsyncTask<Task, Void,Void>{
        private TaskDao mTaskDao;

        public insertTaskAsync(TaskDao taskDao){
            this.mTaskDao = taskDao;
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            mTaskDao.insertTask(tasks[0]);
            return null;
        }
    }

    private class deleteTask extends AsyncTask<Task,Void,Void>{
        private TaskDao mTaskDao;

        public deleteTask(TaskDao taskDao){
            this.mTaskDao = taskDao;
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            mTaskDao.deleteTask(tasks[0]);
            return null;
        }
    }
}
