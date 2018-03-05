package com.example.yousuf.shimmereffectdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yousuf.shimmereffectdemo.R;
import com.example.yousuf.shimmereffectdemo.model.FlickerPublicItem;
import com.example.yousuf.shimmereffectdemo.viewholder.BaseAnimViewHolder;
import com.example.yousuf.shimmereffectdemo.viewholder.EmptyViewHolder;
import com.example.yousuf.shimmereffectdemo.viewholder.ItemViewHolder;

import java.util.List;

/**
 * Created by yousuf on 3/4/18.
 */

public class ListItemAdapter extends RecyclerView.Adapter<BaseAnimViewHolder>{
    private List<FlickerPublicItem> itemList;
    private final int itemsOnScreen;

    public static final int EMPTY_VIEW_TYPE = 0;
    public static final int DATA_VIEW_TYPE = 1;

    String TAG = getClass().getSimpleName();


    public ListItemAdapter(List<FlickerPublicItem> itemList, int itemsOnScreen) {

        this.itemList = itemList;
        this.itemsOnScreen = itemsOnScreen;

        if (this.itemList.size() == 0){
            for (int i = 0; i < itemsOnScreen; i++) {
                this.itemList.add(null);
            }
        }


        Log.i(TAG, "" + itemsOnScreen + " is added for shimmer animation");
    }

    @Override
    public BaseAnimViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = null;

        switch (viewType) {

            case EMPTY_VIEW_TYPE:
                rootView = LayoutInflater.from(parent.getContext()).inflate( R.layout.row_item_empty,  parent, false);
                return new EmptyViewHolder(rootView);

            case DATA_VIEW_TYPE:
                rootView = LayoutInflater.from(parent.getContext()).inflate( R.layout.row_item,  parent, false);
                return new ItemViewHolder(rootView);


            default:
                rootView = LayoutInflater.from(parent.getContext()).inflate( R.layout.row_item_empty,  parent, false);
                return new EmptyViewHolder(rootView);

        }




    }

    @Override
    public void onBindViewHolder(BaseAnimViewHolder holder, int position) {
        holder.bindView(itemList.get(position));
    }


    @Override
    public int getItemViewType(int position) {

        if (itemList.get(position)== null) {
            return EMPTY_VIEW_TYPE;
        }else {
            return DATA_VIEW_TYPE;
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}





