package com.example.greenhouses.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenhouses.R;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

//    List<CombinedData> combinedDatas;
    Context context;
    String title;

//    public DataAdapter(List<CombinedData> combinedDatas, Context context, String title) {
////        this.combinedDatas = combinedDatas;
//        this.context = context;
//        this.title = title;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_tempruture, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.chart.setData(combinedDatas.get(position));
//        holder.chart.animateY(2000);
//        holder.chart.getDescription().setText(title);
//        holder.textTitle.setText(String.format("%s  %d", title, position+1));
    }

    @Override
    public int getItemCount() {
//        return combinedDatas.size();
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textTitle;
//        public CombinedChart chart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.title);
//            chart = itemView.findViewById(R.id.chart);
        }
    }
}
