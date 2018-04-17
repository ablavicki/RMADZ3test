package com.ferit.ablavicki.rmadz3;

public class Task {

    private int priority;
    private String taskTitle;
    private String taskCategory;

    public Task(int priority, String taskTitle, String taskCategory) {
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

}
