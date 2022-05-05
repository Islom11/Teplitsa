package com.example.greenhouses.fragments;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.greenhouses.App;
import com.example.greenhouses.R;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

import org.json.JSONException;
import org.json.JSONObject;

public class AuthFragment extends Fragment {

    private String error;
    private String errorAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_auth, container, false);

        final TextInputEditText loginEdit = root.findViewById(R.id.login);
        final TextInputEditText parolParol = root.findViewById(R.id.parol);

       error = getString(R.string.error);
       errorAuth = getString(R.string.error_auth);

        root.findViewById(R.id.sigin)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        openFragment();
                        assert loginEdit.getText() != null;
                        assert parolParol.getText() != null;
                        boolean b = false;
                        if (loginEdit.getText().toString().replace(" ","").equals("")){
                            loginEdit.setError(error);
                            b = true;
                        }

                        if (parolParol.getText().toString().replace(" ","").equals("")){
                            parolParol.setError(error);
                            return;
                        }

                        if (!b) {
                            sendData(loginEdit.getText().toString(),parolParol.getText().toString());
                        }

                    }
                });

        return root;
    }

    private void sendData(final String login, final String parol) {
        JSONObject data = new JSONObject();
        try {
            data.put("username",login);
            data.put("password",parol);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        App.getInstance()
                .getData()
                .getAuth(data.toString())
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(@Nullable Call<String> call, @Nullable  Response<String> response) {
                        assert response != null;
                        assert response.body() != null;
                        if (response.body().equals("[]")) {
                            Toast.makeText(getContext(),errorAuth,Toast.LENGTH_LONG).show();
                        }else {
                            try {
                                JSONObject result = new JSONObject(response.body());
                                saveData(
                                        result.getString("refresh"),
                                        result.getString("access")
                                        );
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
//                            saveData(login,parol);
                        }
                    }

                    @Override
                    public void onFailure(@Nullable Call<String> call, @Nullable Throwable t) {
                        Toast.makeText(getContext(),error,Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void saveData(String accesToken, String refreshToken){
        assert getActivity()  != null;
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = getActivity().getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putString("accesToken",accesToken);
        editor.putString("refreshToken",refreshToken);
        editor.putString("auth","1");
        editor.apply();
        openFragment();
    }

    private void openFragment() {
        assert getActivity() != null;
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFrame, new MainFrame())
                .commit();
    }
}
