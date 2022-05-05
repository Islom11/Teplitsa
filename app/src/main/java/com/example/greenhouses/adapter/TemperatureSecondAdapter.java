package com.example.greenhouses.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenhouses.R;
import com.example.greenhouses.data.Temperature;

import java.util.List;

public class TemperatureSecondAdapter extends RecyclerView.Adapter<TemperatureSecondAdapter.ViewHolder> {

    List<Temperature> list;
    Context context;

    public TemperatureSecondAdapter(List<Temperature> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_temp_2, parent, false);
        return new TemperatureSecondAdapter.ViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        if (position == 5) {
//            holder.linearDeagre.setVisibility(View.GONE);
//            holder.tempDate.setVisibility(View.VISIBLE);
//        }
        Temperature temp = list.get(position);
        if (position != 0) {
            if (!temp.getDate().equals(list.get(position-1).getDate())){
                holder.tempDate.setVisibility(View.VISIBLE);
                holder.tempDate.setText(temp.getDate());
            }else {
                holder.tempDate.setVisibility(View.GONE);
            }
        }else {
            holder.tempDate.setVisibility(View.VISIBLE);
            holder.tempDate.setText(temp.getDate());
        }
        holder.tempDeagre.setText(String.format("%.1f C",temp.getDagre()));
        holder.tempTime.setText(temp.getTime());
        holder.tempProg.setProgress((int) (temp.getDagre()+30));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public LinearLayout linearDeagre;
        public TextView tempDeagre;
        public ProgressBar tempProg;
        public TextView tempTime;
        public TextView tempDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearDeagre = itemView.findViewById(R.id.tempLinear);
            tempDeagre = itemView.findViewById(R.id.tempDeagre);
            tempProg = itemView.findViewById(R.id.tempProg);
            tempTime = itemView.findViewById(R.id.tempTime);
            tempDate = itemView.findViewById(R.id.tempDate);
        }
    }
}
