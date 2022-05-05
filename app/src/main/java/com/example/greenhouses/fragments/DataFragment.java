package com.example.greenhouses.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenhouses.R;
import com.example.greenhouses.adapter.CameraAdapter;
import com.example.greenhouses.adapter.DataAdapter;


public class DataFragment extends Fragment {

    RecyclerView recyclerView;
    DataAdapter adapter;
    CameraAdapter cameraAdapter;
//    List<CombinedData> combinedDatas;
    String title;
    int[] cameras;

    public DataFragment(int[] cameras, String title) {
        this.cameras = cameras;
        this.title = title;
    }

//    public DataFragment(List<CombinedData> combinedDatas, String title) {
//        this.combinedDatas = combinedDatas;
//        this.title = title;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_data, container, false);

        recyclerView = root.findViewById(R.id.recData);
        list();


        root.findViewById(R.id.dataBack)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().onBackPressed();
                    }
                });
/*
        root.findViewById(R.id.dataHistory)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openFragment(new HistoryDataFragment());
                    }
                });

        root.findViewById(R.id.getDataHistory)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NetworkService.getInstance()
                                .getData()
                                .getData()
                                .enqueue(new Callback<String>() {
                                    @Override
                                    public void onResponse(Call<String> call, Response<String> response) {
                                        Log.i("xabarY", response.body());
                                        ((TextView) root.findViewById(R.id.dataText))
                                                .setText(response.body());
                                    }

                                    @Override
                                    public void onFailure(Call<String> call, Throwable t) {
                                        Log.i("xabarN", t.getMessage());
                                    }
                                });
                    }
                });


         */
        return root;
    }

    private void list() {
//        if (combinedDatas != null) {
//            adapter = new DataAdapter(combinedDatas, getContext(), title);
//            recyclerView.setAdapter(adapter);
//        }else {
//            cameraAdapter = new CameraAdapter(cameras, getContext(), title);
//            recyclerView.setAdapter(cameraAdapter);
//        }
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    void openFragment(Fragment fragment){
        assert getActivity() != null;
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFrame, fragment)
                .addToBackStack("DataFragment")
                .commit();
    }

}
