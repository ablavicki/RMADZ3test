package com.ferit.ablavicki.rmadz3;

import android.app.Application;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Task.class}, version=1)
public abstract class TaskDatabase extends RoomDatabase{
    private static TaskDatabase sInstance;
    private static final String DATABASE_NAME = "tasks.db";

    public static TaskDatabase getInstance(Application application){
        if(sInstance == null){
            sInstance = Room.databaseBuilder(application.getApplicationContext(),
                    TaskDatabase.class, DATABASE_NAME).build();
        }
        return sInstance;
    }

    public abstract TaskDao taskDao();

}
