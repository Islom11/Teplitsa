package com.example.greenhouses.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenhouses.R;
import com.example.greenhouses.data.Temperature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TemperatureMainAdapter extends RecyclerView.Adapter<TemperatureMainAdapter.ViewHolder> {

    private List<List<Temperature>> lists;
    private Context context;

    ArrayList<String> strings;

    public TemperatureMainAdapter(List<List<Temperature>> lists, Context context) {
        this.lists = lists;
        this.context = context;
        strings = new ArrayList<>(Arrays.asList(context.getResources().getStringArray(R.array.temp_title)));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_temp_1, parent, false);
        return new TemperatureMainAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TemperatureSecondAdapter secondAdapter = new TemperatureSecondAdapter(lists.get(position), context);
        holder.recyclerView.setAdapter(secondAdapter);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false));
        holder.recyclerView.scrollToPosition(lists.get(position).size()-1);
        holder.tempTitle.setText(strings.get(position));
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

         public RecyclerView recyclerView;
         public TextView tempTitle;

         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             recyclerView = itemView.findViewById(R.id.recTemp1);
             tempTitle = itemView.findViewById(R.id.tempTitle);
         }
     }

}
