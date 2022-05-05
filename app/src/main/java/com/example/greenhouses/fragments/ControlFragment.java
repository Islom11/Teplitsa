package com.example.greenhouses.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.greenhouses.App;
import com.example.greenhouses.R;
import com.example.greenhouses.data.Data;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.List;

public class ControlFragment extends Fragment {

    SwitchMaterial firstBurden;
    SwitchMaterial secondBurden;
    SwitchMaterial thirdBurden;
    TextView servoUp;
    TextView servoDown;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_control, container, false);

        root.findViewById(R.id.controlBack)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().onBackPressed();
                    }
                });

        firstBurden = root.findViewById(R.id.firstBurden);
        secondBurden = root.findViewById(R.id.secondBurden);
        thirdBurden = root.findViewById(R.id.thirdBurden);
//
//        firstBurden.setOnCheckedChangeListener(changeListener);
//        secondBurden.setOnCheckedChangeListener(changeListener);
//        thirdBurden.setOnCheckedChangeListener(changeListener);

        List<Data> dataList = App.getInstance().getDataBase().dataDao().getAll();
        int n = dataList.size()-1;
        if (n != -1) {
            Data data = dataList.get(n);
            servoUp = root.findViewById(R.id.servoUp);
            servoDown = root.findViewById(R.id.servoDown);
//            servoUp.setText(String.valueOf(data.getServoUps()));
//            servoDown.setText(String.valueOf(data.getServoDown()));
//
//            firstBurden.setChecked(data.isConOne());
//            secondBurden.setChecked(data.isConTwo());
//            thirdBurden.setChecked(data.isConThree());
        }
        return root;
    }

    CompoundButton.OnCheckedChangeListener changeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked){
                changeSwitch(buttonView.getId());
            }
        }
    };

    void changeSwitch(int id){
        firstBurden.setChecked(id == R.id.firstBurden);
        secondBurden.setChecked(id == R.id.secondBurden);
        thirdBurden.setChecked(id == R.id.thirdBurden);
    }

}


