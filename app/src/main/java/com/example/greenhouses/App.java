package com.example.greenhouses;

import android.app.Application;

import androidx.room.Room;

import com.example.greenhouses.data.DataBase;
import com.example.greenhouses.data.DataDao;
import com.example.greenhouses.internet.JsonData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class App extends Application {
    private static App instance;
    private DataBase dataBase;
    private DataDao dataDao;

//    private static final String BASE_URL = "https://teplitsy.uz/";
    private static final String BASE_URL = "https://api.server.laba005.ru/";
//    private static final String BASE_URL = "http://teplitsatsu.pythonanywhere.com/auth/token/login/";
    private Retrofit mRetrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        dataBase = Room.databaseBuilder(getApplicationContext(), DataBase.class, "db")
                .allowMainThreadQueries()
                .build();

        dataDao = dataBase.dataDao();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(client.build())
                .build();

    }

    public static App getInstance() {
        return instance;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public DataDao getDataDao() {
        return dataDao;
    }

    public JsonData getData() {
        return mRetrofit.create(JsonData.class);
    }
}
