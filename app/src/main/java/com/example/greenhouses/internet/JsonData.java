package com.example.greenhouses.internet;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface JsonData {
    @GET("/dataJson")
    Call<String> getData();

    @POST("api/token/")
    @Headers({"Content-Type:application/json"})
    Call<String> getAuth(@Body String data);

    @FormUrlEncoded
    @POST("db/")
    Call<String> getData(@Field("task") String task, @Field("id") String id);

    @GET("api/sensor-data/")
    Call<String> getSensorData(@Header("Authorization") String token);

//    @POST("/dataJson")
//    public Call<String> getData();
}
