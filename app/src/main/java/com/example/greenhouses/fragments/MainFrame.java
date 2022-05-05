package com.example.greenhouses.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.greenhouses.App;
import com.example.greenhouses.R;
import com.example.greenhouses.data.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFrame extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_2, container, false);

        String fragment = Objects.requireNonNull(getActivity()).getIntent().getStringExtra("fragment");

        getActivity().getIntent().putExtra("fragment","");
        if (fragment != null && fragment.equals("setting")) {
            openFragment(new SettingFragment());
        }

        root.findViewById(R.id.menuSetting).setOnClickListener(this);
        root.findViewById(R.id.menuControl).setOnClickListener(this);
        root.findViewById(R.id.menuTemp).setOnClickListener(this);
        root.findViewById(R.id.menuHumdty).setOnClickListener(this);
        root.findViewById(R.id.menuCamera).setOnClickListener(this);

        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R.attr.fonDialog, typedValue, true);
        final int theme = typedValue.data;

        final String wait = getString(R.string.wait);
        final String succes = getString(R.string.succes);
        final String error = getString(R.string.error);

        SharedPreferences preferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        final String token =  preferences.getString("accesToken","");

        root.findViewById(R.id.menuUpdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog dialog = new ProgressDialog(getContext(),theme);
                dialog.setMessage(wait);
                dialog.show();

//                List<Data> dataList = App.getInstance().getDataBase().dataDao().getAll();
//                int n = dataList.size();
//                if (n != 0) {
//                    n = dataList.get(n-1).getIdDB();
//                }

                App.getInstance()
                        .getData()
                        .getSensorData("Bearer"+token)
                        .enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(@Nullable Call<String> call, @Nullable Response<String> response) {
                                try {
                                    assert response != null;
                                    if (response.body() != null) {
                                        JSONObject object = new JSONObject(response.body());
                                        JSONArray jsonArray = object.getJSONArray("results");
                                        int n = jsonArray.length();
                                        if (n > 0) {
                                            App.getInstance()
                                                    .getDataBase()
                                                    .dataDao()
                                                    .deleteAll();
                                        }
                                        for (int i = 0; i < n; ++i) {
                                            object = jsonArray.getJSONObject(i);
                                            String[] date = object.getString("created_at").split("T");
                                            Data data = new Data(
                                                    object.getInt("id"),
                                                    object.getString("owner"),
                                                    object.getString("created_at"),
                                                    (float)  object.getDouble("temp_upstairs"),
                                                    (float)  object.getDouble("temp_downstairs"),
                                                    (float)  object.getDouble("temp_in_ground"),
                                                    (float)  object.getDouble("temp_street"),
                                                    (float)  object.getDouble("humidity_greenhouse"),
                                                    (float)  object.getDouble("humidity_greenhouse_in_ground"),
                                                    date[0],
                                                    date[1].substring(0,5)
                                            );

                                            App.getInstance()
                                                    .getDataBase()
                                                    .dataDao()
                                                    .insert(data);
                                        }
                                        Toast.makeText(getContext(), succes, Toast.LENGTH_LONG).show();
                                    }else {
                                        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                dialog.dismiss();
                            }

                            @Override
                            public void onFailure(@Nullable Call<String> call, @Nullable Throwable t) {
                                Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
                                dialog.dismiss();
                            }
                        });
            }
        });
        return root;
    }

    void openFragment(Fragment fragment) {
        assert getActivity() != null;
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFrame, fragment)
                .addToBackStack("MainFrame")
                .commit();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.menuSetting) {
            openFragment(new SettingFragment());
        } else if (v.getId() == R.id.menuControl) {
            openFragment(new ControlFragment());
        } else if (v.getId() == R.id.menuTemp) {
            openFragment(new TemperatureFragment());
        } else if (v.getId() == R.id.menuHumdty) {
            openFragment(new HumdtyFragment());
        } else if (v.getId() == R.id.menuCamera) {
            openFragment(new CameraFragment());
        }
    }
}
