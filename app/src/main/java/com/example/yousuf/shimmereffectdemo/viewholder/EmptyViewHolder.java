package com.example.yousuf.shimmereffectdemo.viewholder;

import android.view.View;

import com.example.yousuf.shimmereffectdemo.R;
import com.example.yousuf.shimmereffectdemo.model.FlickerPublicItem;
import com.facebook.shimmer.ShimmerFrameLayout;

/**
 * Created by yousuf on 3/4/18.
 */

public class EmptyViewHolder extends BaseAnimViewHolder {

    ShimmerFrameLayout shimmerFrameLayout;


    public EmptyViewHolder(View itemView) {
        super(itemView);

        shimmerFrameLayout = itemView.findViewById(R.id.shimer_view_container);


    }

    @Override
    public void bindView(FlickerPublicItem itemModel) {
        shimmerFrameLayout.startShimmerAnimation();
    }


}
