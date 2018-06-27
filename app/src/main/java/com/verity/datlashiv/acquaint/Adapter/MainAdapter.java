package com.verity.datlashiv.acquaint.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.verity.datlashiv.acquaint.R;



public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private int image[] = {R.drawable.os, R.drawable.lang, R.drawable.db};
    private String[] name = {"OS", "Languages", "DataBase"};


    public MainAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleview.setText(name[position]);
        holder.imageview.setImageResource(image[position]);

    }

    @Override
    public int getItemCount() {
        return image.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleview;
        ImageView imageview;

        public ViewHolder(View itemView) {
            super(itemView);

            titleview = itemView.findViewById(R.id.title_row);
            imageview = itemView.findViewById(R.id.image_row);
        }
    }
}
