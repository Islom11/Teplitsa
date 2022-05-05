package com.example.greenhouses.adapter;

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
import com.example.greenhouses.data.Humdty;

import java.util.List;

public class HumdtySecondAdapter extends RecyclerView.Adapter<HumdtySecondAdapter.ViewHolder> {

    List<Humdty> list;
    Context context;

    public HumdtySecondAdapter(List<Humdty> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_humdty_2, parent, false);
        return new HumdtySecondAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        if (position == 5) {
//            holder.linearDeagre.setVisibility(View.GONE);
//            holder.humdtyDate.setVisibility(View.VISIBLE);
//        }

        Humdty humdty = list.get(position);

        if (position != 0) {
            if (!humdty.getDate().equals(list.get(position-1).getDate())){
                holder.humdtyDate.setVisibility(View.VISIBLE);
                holder.humdtyDate.setText(humdty.getDate());
            }else {
                holder.humdtyDate.setVisibility(View.GONE);
            }
        }else {
            holder.humdtyDate.setVisibility(View.VISIBLE);
            holder.humdtyDate.setText(humdty.getDate());
        }


        holder.humdtyDeagre.setText(String.valueOf((int) humdty.getDagre()) + " %");
        holder.humdtyProg.setProgress((int) humdty.getDagre());
        holder.humdtyTime.setText(humdty.getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public LinearLayout linearDeagre;
        public TextView humdtyDeagre;
        public ProgressBar humdtyProg;
        public TextView humdtyTime;
        public TextView humdtyDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearDeagre = itemView.findViewById(R.id.humdtyLinear);
            humdtyDeagre = itemView.findViewById(R.id.humdtyDeagre);
            humdtyProg = itemView.findViewById(R.id.humdtyProg);
            humdtyTime = itemView.findViewById(R.id.humdtyTime);
            humdtyDate = itemView.findViewById(R.id.humdtyDate);
        }
    }
}
