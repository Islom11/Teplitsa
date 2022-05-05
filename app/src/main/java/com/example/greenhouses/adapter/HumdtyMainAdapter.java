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
import com.example.greenhouses.data.Humdty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HumdtyMainAdapter extends RecyclerView.Adapter<HumdtyMainAdapter.ViewHolder> {

    private List<List<Humdty>> lists;
    private Context context;

    private ArrayList<String> strings;

    public HumdtyMainAdapter(List<List<Humdty>> lists, Context context) {
        this.lists = lists;
        this.context = context;
        strings = new ArrayList<>(Arrays.asList(context.getResources().getStringArray(R.array.hum_title)));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_humdty_1, parent, false);
        return new HumdtyMainAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HumdtySecondAdapter secondAdapter = new HumdtySecondAdapter(lists.get(position), context);
        holder.recyclerView.setAdapter(secondAdapter);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false));
        holder.recyclerView.scrollToPosition(lists.get(position).size()-1);
        holder.textInfoHum.setText(strings.get(position));
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

         public RecyclerView recyclerView;
         public TextView textInfoHum;

         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             recyclerView = itemView.findViewById(R.id.recHumdty1);
             textInfoHum = itemView.findViewById(R.id.textInfoHum);
         }
     }

}
