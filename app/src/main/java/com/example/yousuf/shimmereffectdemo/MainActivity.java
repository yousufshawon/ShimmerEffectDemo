package com.example.yousuf.shimmereffectdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.yousuf.shimmereffectdemo.adapter.ListItemAdapter;
import com.example.yousuf.shimmereffectdemo.model.FlickerPublicItem;
import com.example.yousuf.shimmereffectdemo.model.FlickerPublicResponse;
import com.example.yousuf.shimmereffectdemo.rest.ApiClient;
import com.example.yousuf.shimmereffectdemo.rest.FlickerService;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private String TAG = getClass().getSimpleName();

    RecyclerView recyclerView;
    private ListItemAdapter listItemAdapter;
    private List<FlickerPublicItem> itemFlickerList = new ArrayList<>();
    private int screenHeight = 0;
    private int screenWidth = 0;
    private Retrofit flickerRetrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        screenHeight = displayMetrics.heightPixels;

        screenWidth = displayMetrics.widthPixels;

        initializeUI();

        fetchData();
    }

    private void fetchData() {

        flickerRetrofit = ApiClient.getClient();

        FlickerService flickerService = flickerRetrofit.create(FlickerService.class);

        Call<FlickerPublicResponse> call = flickerService.getPublicPhotos();

        call.enqueue(new Callback<FlickerPublicResponse>() {
            @Override
            public void onResponse(Call<FlickerPublicResponse> call, retrofit2.Response<FlickerPublicResponse> response) {
                if (response != null) {
                    FlickerPublicResponse flickerPublicResponse = response.body();
                    List<FlickerPublicItem> flickerPublicItems = flickerPublicResponse.getItemList();

                    itemFlickerList.clear();
                    itemFlickerList.addAll(flickerPublicItems);


                    listItemAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<FlickerPublicResponse> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
                itemFlickerList.clear();
                listItemAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    private Context getContext() {
        return this;
    }

    private void initializeUI() {

        recyclerView = findViewById(R.id.recyclerView);

        View view = LayoutInflater.from(getContext()).inflate(R.layout.row_item_empty, null);
        view.measure(
                View.MeasureSpec.makeMeasureSpec(screenWidth, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

        int listItemHeight = view.getMeasuredHeight();

        Log.i(TAG, "list item height: " + listItemHeight);


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        int itemsOnScreen = (screenHeight - getActionBarHeight() )/listItemHeight + 1;

        listItemAdapter = new ListItemAdapter(itemFlickerList, itemsOnScreen);
        recyclerView.setAdapter(listItemAdapter);
    }


    private int getActionBarHeight(){

        int actionBarHeight = 0;

        try {
            // Calculate ActionBar height
            TypedValue tv = new TypedValue();
            if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
                actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
            }

        }catch (Exception e){

        }


        return actionBarHeight;

    }


    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }






}
