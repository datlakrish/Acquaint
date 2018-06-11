package com.verity.datlashiv.acquaint.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.verity.datlashiv.acquaint.ModelClasses.MainCourse;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private ArrayList<MainCourse> course;

    public MainAdapter(Context context, ArrayList<MainCourse> course) {
        this.context = context;
        this.course = course;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainCourse row = course.get(position);

    }

    @Override
    public int getItemCount() {
        return course.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{



        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
