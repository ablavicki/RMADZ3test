package com.ferit.ablavicki.rmadz3;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM Task")
    LiveData<List<Task>> getTasks();

    @Delete
    void deleteTask(Task task);

    @Insert
    void insertTask(Task task);

    @Query("SELECT * FROM Task WHERE category = :category")
    LiveData<List<Task>> getTasksBy(String category);



    @Query("SELECT category FROM Task")
    String [] getCategories1();

}
