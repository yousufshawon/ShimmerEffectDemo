package com.example.yousuf.shimmereffectdemo.viewholder;

import android.support.v4.content.ContextCompat;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.yousuf.shimmereffectdemo.R;
import com.example.yousuf.shimmereffectdemo.model.FlickerPublicItem;
import com.example.yousuf.shimmereffectdemo.model.Media;

/**
 * Created by yousuf on 3/4/18.
 */

public class ItemViewHolder extends BaseAnimViewHolder{


    public ItemViewHolder(View itemView) {
        super(itemView);

    }


    public void bindView(FlickerPublicItem itemModel){


        if ( itemModel.getTitle() != null ){
            textViewTitle.setText(itemModel.getTitle());
        }else {
            textViewTitle.setText("");
        }

        textViewTitle.setBackgroundColor(ContextCompat.getColor(textViewTitle.getContext(), android.R.color.transparent));


        textViewSubTitle.setBackgroundColor(ContextCompat.getColor(textViewSubTitle.getContext(), android.R.color.transparent));

        if ( itemModel.getAuthor()!= null) {
            textViewSubTitle.setText(itemModel.getAuthor());
        }else {
            textViewSubTitle.setText("");
        }


        Media media = itemModel.getMedia();
        if (media.getM() != null && media.getM().length() > 0 ) {
            Glide.with(imageView.getContext())
                    .load(media.getM())
                    .into(imageView);
        }else {

            imageView.setBackgroundColor(ContextCompat.getColor(imageView.getContext(), R.color.light_gray));
        }


    }

}