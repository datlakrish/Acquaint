package com.verity.datlashiv.acquaint.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.verity.datlashiv.acquaint.ModelClasses.MainCourse;
import com.verity.datlashiv.acquaint.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private Context context;
    private ArrayList<MainCourse> mainCourses;

    public RecyclerAdapter(){
    }

    public RecyclerAdapter(Context context, ArrayList<MainCourse> mainCourses) {
        this.context = context;
        this.mainCourses = mainCourses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainCourse mc = mainCourses.get(position);
        holder.concepts.setText(mc.getName());
        Picasso.with(context).load(mc.getImage()).fit().into(holder.con_img);
    }

    @Override
    public int getItemCount() {
        return mainCourses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView concepts;
        ImageView con_img;

        public ViewHolder(View itemView) {
            super(itemView);
            concepts = itemView.findViewById(R.id.title_row);
            con_img = itemView.findViewById(R.id.image_row);
        }
    }
}
