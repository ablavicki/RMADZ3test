package com.ferit.ablavicki.rmadz3;

import android.arch.lifecycle.LiveData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddTaskActivity extends AppCompatActivity {

    @BindView(R.id.sCategory)
    Spinner sCategory;
    @BindView(R.id.sPriority)
    Spinner sPriority;

    private TaskDatabase mDatabase;
    private String [] mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        ButterKnife.bind(this);
        setupSpinner();
    }

    private void setupSpinner() {
        mData = mDatabase.taskDao().getCategories1();
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, mData);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sCategory.setAdapter(adapter);
    }


}
