package com.verity.datlashiv.acquaint.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.verity.datlashiv.acquaint.ModelClasses.MainCourse;
import com.verity.datlashiv.acquaint.R;

import java.util.ArrayList;


public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    private Context context;
    private ArrayList<MainCourse> mainCourses;

    public MyRecyclerAdapter(){
    }

    public MyRecyclerAdapter(Context context, ArrayList<MainCourse> mainCourses) {
        this.context = context;
        this.mainCourses = mainCourses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainCourse mc = mainCourses.get(position);
        holder.concepts.setText(mc.getName());
    }

    @Override
    public int getItemCount() {
        return mainCourses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView concepts;

        public ViewHolder(View itemView) {
            super(itemView);
            concepts = itemView.findViewById(R.id.single_row);
        }
    }
}
