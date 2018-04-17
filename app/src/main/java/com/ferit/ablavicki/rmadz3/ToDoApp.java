package com.ferit.ablavicki.rmadz3;

import android.app.Application;

public class ToDoApp extends Application {

    private static ToDoApp sInstance;

    public static ToDoApp getInstance(){
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

}
