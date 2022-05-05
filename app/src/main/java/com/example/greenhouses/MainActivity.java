package com.example.greenhouses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.widget.Toast;

import com.example.greenhouses.fragments.AuthFragment;
import com.example.greenhouses.fragments.MainFrame;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private String back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sp = getSharedPreferences("data",MODE_PRIVATE);
        String theme = sp.getString("theme","white");
        assert theme != null;
        switch (theme) {
            case "white":
                setTheme(R.style.AppTheme);
                break;
            case "black":
                setTheme(R.style.AppTheme2);
                break;
        }

        String lan = sp.getString("lan","ru");
        assert lan != null;
        switch (lan) {
            case "ru":
                setAppLanguage("ru");
                break;
            case "en":
                setAppLanguage("en");
                break;
            case "uz":
                setAppLanguage("uz");
                break;
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String auth = sp.getString("auth","0");
        assert auth != null;

//        String fragment = getIntent().getStringExtra("fragment");
//        if (fragment != null && fragment.equals("setting")) {
        if (auth.equals("1")) {
            openFragment(new MainFrame());
        }else {
            openFragment(new AuthFragment());
        }

        back = getString(R.string.back);

    }

    private void openFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFrame, fragment)
                .commit();
    }

    private boolean doubleClicedExit = false;

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            if (doubleClicedExit) {
                super.onBackPressed();
                return;
            }

            this.doubleClicedExit = true;
            Toast.makeText(getApplicationContext(), back, Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleClicedExit = false;
                }
            }, 2000);
        }else {
            getSupportFragmentManager().popBackStack();
        }
    }

    public void setAppLanguage(String localCode){
        Resources resources = getResources();
        DisplayMetrics dm =resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        config.setLocale(new Locale(localCode.toLowerCase()));
        resources.updateConfiguration(config, dm);
    }
}