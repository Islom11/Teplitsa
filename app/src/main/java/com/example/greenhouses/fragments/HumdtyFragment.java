package com.example.greenhouses.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenhouses.App;
import com.example.greenhouses.R;
import com.example.greenhouses.adapter.HumdtyMainAdapter;
import com.example.greenhouses.data.Data;
import com.example.greenhouses.data.Humdty;

import java.util.ArrayList;
import java.util.List;

public class HumdtyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_humdty, container, false);

        root.findViewById(R.id.back)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().onBackPressed();
                    }
                });

        List<List<Humdty>> lists = new ArrayList<>();

        List<Humdty> hudtyGreen = new ArrayList<>();
        List<Humdty> hudtyGround = new ArrayList<>();

        List<Data> dataList = App.getInstance().getDataBase().dataDao().getAll();
        for (Data data : dataList) {
            hudtyGreen.add(new Humdty(data.getIdDB(),data.getHumGreen(),data.getDate(),data.getTime()));
            hudtyGround.add(new Humdty(data.getIdDB(),data.getHumGround(),data.getDate(),data.getTime()));
        }

        lists.add(hudtyGreen);
        lists.add(hudtyGround);


//        for (int i = 0; i < 5; ++i) {
//            List<Humdty> hudities = new ArrayList<>();
//            for (int j = 0; j < 10; ++j) {
//                hudities.add(new Humdty());
//            }
//            lists.add(hudities);
//        }

        HumdtyMainAdapter adapter = new HumdtyMainAdapter(lists, getContext());

        RecyclerView recyclerView = root.findViewById(R.id.recHumdty);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;
    }
}
