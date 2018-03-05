package com.example.yousuf.shimmereffectdemo.rest;

import com.example.yousuf.shimmereffectdemo.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yousuf on 3/5/18.
 */

public class ApiClient {

    public static final String BASE_URL = BuildConfig.API_BASE_URL;

    private static Retrofit flickerRetrofit = null;


    public static Retrofit getClient() {
        if (flickerRetrofit == null) {

            GsonBuilder gsonBuilder = new GsonBuilder();
            // gsonBuilder.registerTypeAdapter(DateTime.class, new DateTimeConverter());
            Gson gson = gsonBuilder.create();


            flickerRetrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl(BASE_URL)
                    .build();

        }

        return flickerRetrofit;
    }
}
