package com.example.yousuf.shimmereffectdemo.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yousuf on 3/4/18.
 */

public class FlickerPublicResponse {


    @SerializedName("title")
    String titile;

    @SerializedName("link")
    String link;

    @SerializedName("description")
    String description;

    @SerializedName("modified")
    String modified;

    @SerializedName("generator")
    String generator;

    @SerializedName("items")
    List<FlickerPublicItem> itemList;


    public String getTitile() {
        return titile;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getModified() {
        return modified;
    }

    public List<FlickerPublicItem> getItemList() {
        return itemList;
    }

    @Override
    public String toString() {
        return "FlickerPublicResponse{" +
                "titile='" + titile + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", modified='" + modified + '\'' +
                ", itemList=" + itemList == null ? "[null]" : Arrays.toString(itemList.toArray()) +
                '}';
    }
}
