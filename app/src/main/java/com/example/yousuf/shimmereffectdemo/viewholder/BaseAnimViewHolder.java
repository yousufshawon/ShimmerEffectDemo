package com.example.yousuf.shimmereffectdemo.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yousuf.shimmereffectdemo.R;
import com.example.yousuf.shimmereffectdemo.model.FlickerPublicItem;

/**
 * Created by yousuf on 3/4/18.
 */

public abstract class BaseAnimViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textViewTitle, textViewSubTitle;

    public BaseAnimViewHolder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView);
        textViewTitle = itemView.findViewById(R.id.textViewTitle);
        textViewSubTitle = itemView.findViewById(R.id.textViewSubTitle);
    }

    abstract public void bindView(FlickerPublicItem itemModel);
}
