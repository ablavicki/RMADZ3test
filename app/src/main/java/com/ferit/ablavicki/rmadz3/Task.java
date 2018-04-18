package com.ferit.ablavicki.rmadz3;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Task {

    @PrimaryKey int id;
    @ColumnInfo(name = "title") private String taskTitle;
    @ColumnInfo(name = "category") private String taskCategory;
    @ColumnInfo(name = "priority") private int priority;

    public Task(int id, int priority, String taskTitle, String taskCategory) {
        this.id = id;
        this.priority = priority;
        this.taskTitle = taskTitle;
        this.taskCategory = taskCategory;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(String taskCategory) {
        this.taskCategory = taskCategory;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "mTitle='" + taskTitle + '\'' +
                ", mCategory='" + taskCategory + '\'' +
                ", mPriority='" + priority + '\'' +
                '}';
    }

}
