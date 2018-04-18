package com.ferit.ablavicki.rmadz3;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvTasks)
    RecyclerView rvTasks;

    private TaskListViewModel mTaskListViewModel;

    private TaskClickCallback mOnTaskClickListener = new TaskClickCallback(){

        @Override
        public void onClick(Task task) {
            String message = task.getTaskTitle();
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onLongClick(Task task) {
            mTaskListViewModel.deleteTask(task);
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mTaskListViewModel = ViewModelProviders.of(this)
                .get(TaskListViewModel.class);
        this.setUpRV();
    }

    private void setUpRV(){
        LinearLayoutManager linearLayout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration divider = new DividerItemDecoration(this, linearLayout.getOrientation());

        TaskAdapter adapter = new TaskAdapter(new ArrayList<Task>(), mOnTaskClickListener);

        rvTasks.setLayoutManager(linearLayout);
        rvTasks.addItemDecoration(divider);
        rvTasks.setAdapter(adapter);


        mTaskListViewModel.getTaskList().observe(this, new android.arch.lifecycle.Observer<List<Task>>() {
            @Override
            public void onChanged(@Nullable List<Task> tasks) {
                ((TaskAdapter)(rvTasks.getAdapter())).refreshData(tasks);
            }
        });

    }

    @OnClick(R.id.fabAddTask)
    public void addTask(){
       Intent intent = new Intent(this, AddTaskActivity.class);
       startActivity(intent);
    }

    @OnClick(R.id.fabAddCategory)
    public void addBook(){
        mTaskListViewModel.insertTask();
    }
    
}
