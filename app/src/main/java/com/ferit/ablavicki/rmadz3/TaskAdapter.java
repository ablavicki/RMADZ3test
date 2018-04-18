package com.ferit.ablavicki.rmadz3;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder>{

    private List<Task> mTasks;
    private TaskClickCallback mCallback;

    public TaskAdapter(List<Task> tasks, TaskClickCallback onTaskClickListener){
        mTasks = new ArrayList<>();
        this.refreshData(tasks);
        mCallback = onTaskClickListener;
    }

    public void refreshData(List<Task> tasks) {
        mTasks.clear();
        mTasks.addAll(tasks);
        this.notifyDataSetChanged();
    }


    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {

        Task current = mTasks.get(position);

        holder.tvCategory.setText(current.getTaskTitle());
        holder.tvCategory.setText(current.getTaskCategory());
        //holder.ivPriority.setImageResource(current.getPriority());

    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.ivPriority)
        ImageView ivPriority;
        @BindView(R.id.tvTaskTitle)
        TextView tvTaskTitle;
        @BindView(R.id.tvCategory)
        TextView tvCategory;

        public TaskViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @OnClick void onTaskClick(){
            mCallback.onClick(mTasks.get(getAdapterPosition()));
        }

        @OnLongClick
        public boolean onTaskLongClick(){
            return mCallback.onLongClick(mTasks.get(getAdapterPosition()));
        }

    }

}
