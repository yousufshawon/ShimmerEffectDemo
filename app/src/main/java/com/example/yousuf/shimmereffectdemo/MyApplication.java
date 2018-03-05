package com.example.yousuf.shimmereffectdemo;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yousuf on 3/5/18.
 */

public class MyApplication extends Application {

    private Retrofit flickerRetrofit;

    @Override
    public void onCreate() {
        super.onCreate();

    }

}
