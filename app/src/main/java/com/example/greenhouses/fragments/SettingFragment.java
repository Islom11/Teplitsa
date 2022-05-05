package com.example.greenhouses.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.greenhouses.App;
import com.example.greenhouses.MainActivity;
import com.example.greenhouses.R;

import static android.content.Context.MODE_PRIVATE;

public class SettingFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_setting, container, false);

        assert getActivity() != null;

        root.findViewById(R.id.settingBack)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        assert getActivity() != null;
                        getActivity().onBackPressed();
                    }
                });

        RadioGroup themeRadioGroup = root.findViewById(R.id.radio_theme);

        SharedPreferences sp = getActivity().getSharedPreferences("data",MODE_PRIVATE);
        String theme = sp.getString("theme","white");
        assert theme != null;
        switch (theme) {
            case "white":
                themeRadioGroup.check(R.id.theme_first);
                break;
            case "black":
                themeRadioGroup.check(R.id.theme_second);
                break;
        }


        themeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.theme_first) {
                    saveTheme("white");
                }else if (checkedId == R.id.theme_second) {
                    saveTheme("black");
                }
            }
        });


        RadioGroup lanRadioGroup = root.findViewById(R.id.radio_language);

        String lan = sp.getString("lan","ru");
        assert lan != null;
        switch (lan) {
            case "ru":
                lanRadioGroup.check(R.id.language_first);
                break;
            case "en":
                lanRadioGroup.check(R.id.language_second);
                break;
            case "uz":
                lanRadioGroup.check(R.id.language_third);
                break;
        }


        lanRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.language_first) {
                    saveLan("ru");
                }else if (checkedId == R.id.language_second) {
                    saveLan("en");
                }else if (checkedId == R.id.language_third) {
                    saveLan("uz");
                }
            }
        });

        root.findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TypedValue typedValue = new TypedValue();
                getActivity().getTheme().resolveAttribute(R.attr.fonDialog, typedValue, true);
                int theme = typedValue.data;
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext(),theme);
                dialog.setMessage(R.string.mess_exit);
                dialog.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        App.getInstance().getDataBase().dataDao().deleteAll();
                        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = getActivity().getSharedPreferences("data", MODE_PRIVATE).edit();
                        editor.putString("auth","");
                        editor.putString("login","");
                        editor.putString("parol","");
                        editor.apply();
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                });
                dialog.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });


        return root;
    }

    private void saveTheme(String theme) {
        assert getActivity()  != null;
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = getActivity().getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putString("theme",theme);
        editor.apply();
        openActivity();
    }

    private void saveLan(String lan) {
        assert getActivity()  != null;
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = getActivity().getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putString("lan",lan);
        editor.apply();
        openActivity();
    }

    private void openActivity() {
        assert getActivity() != null;
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.putExtra("fragment","setting");
        startActivity(intent);
        getActivity().finish();
    }

}
