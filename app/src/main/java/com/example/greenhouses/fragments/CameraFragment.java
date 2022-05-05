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

import com.example.greenhouses.R;
import com.example.greenhouses.adapter.CameraAdapter;

public class CameraFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_camera, container, false);

        root.findViewById(R.id.back)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().onBackPressed();
                    }
                });

        RecyclerView recyclerView = root.findViewById(R.id.recCamera);
        int[] cameras = {R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5};
        CameraAdapter cameraAdapter = new CameraAdapter(cameras,getContext(),getString(R.string.camera));
        recyclerView.setAdapter(cameraAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return root;
    }
}
