package com.example.yousuf.shimmereffectdemo.rest;

import com.example.yousuf.shimmereffectdemo.model.FlickerPublicResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yousuf on 3/4/18.
 */

public interface FlickerService {


    @GET("feeds/photos_public.gne?format=json&nojsoncallback=1")
    Call<FlickerPublicResponse> getPublicPhotos();
}
