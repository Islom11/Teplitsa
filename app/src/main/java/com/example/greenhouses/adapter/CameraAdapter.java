package com.example.greenhouses.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenhouses.R;


public class CameraAdapter extends RecyclerView.Adapter<CameraAdapter.ViewHolder> {

    int[] cameras;
    Context context;
    String title;

    public CameraAdapter(int[] cameras, Context context, String title) {
        this.cameras = cameras;
        this.context = context;
        this.title = title;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_camera, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint({"DefaultLocale", "UseCompatLoadingForDrawables"})
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageDrawable(context.getResources().getDrawable(cameras[position]));
        holder.textTitle.setText(String.format("%s  %d", title, position+1));
    }

    @Override
    public int getItemCount() {
        return cameras.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textTitle;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.title);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
