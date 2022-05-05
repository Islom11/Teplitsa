package com.example.greenhouses.fragments;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.greenhouses.R;
import com.google.android.material.textfield.TextInputEditText;

public class SettingDialogFragment extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        final View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_setting, null, false);
        alert.setView(view);

        view.findViewById(R.id.cancelBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        final  SharedPreferences preferences = getActivity().getSharedPreferences("meta", Context.MODE_PRIVATE);
        String firstNumber = preferences.getString("firstNumber", "");
        String secondNumber = preferences.getString("secondNumber", "");

        final TextInputEditText firstEdit = view.findViewById(R.id.numberFirstEdit);
        final TextInputEditText secondEdit = view.findViewById(R.id.numberSecondEdit);

        if (!firstNumber.equals("") && !secondNumber.equals("")) {
            firstEdit.setText(firstNumber.replace("+7",""));
            secondEdit.setText(secondNumber.replace("+7",""));

            firstEdit.setSelection(10);
        }


        view.findViewById(R.id.saveBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b = false;
                if (firstEdit.getText().length() < 10) {
                    firstEdit.setError("Ошибка");
                    b = true;
                }
                if (secondEdit.getText().length() < 10) {
                    secondEdit.setError("Ошибка");
                    b = true;
                }
                if (b) {
                    return;
                }

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("firstNumber", "+7" + firstEdit.getText().toString());
                editor.putString("secondNumber","+7" + secondEdit.getText().toString());
                editor.apply();

                dismiss();
            }
        });

        return alert.create();
    }
}
