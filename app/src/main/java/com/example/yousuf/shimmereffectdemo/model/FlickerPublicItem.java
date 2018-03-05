package com.example.yousuf.shimmereffectdemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yousuf on 3/4/18.
 */

public class FlickerPublicItem {

    @SerializedName("title")
    String title;

    @SerializedName("link")
    String link;

    @SerializedName("media")
    Media media;

    @SerializedName("date_taken")
    String dateTaken;

    @SerializedName("description")
    String description;

    @SerializedName("published")
    String published;

    @SerializedName("author")
    String author;

    @SerializedName("author_id")
    String authorId;

    @SerializedName("tags")
    String tags;


    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public Media getMedia() {
        return media;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public String getDescription() {
        return description;
    }

    public String getPublished() {
        return published;
    }

    public String getAuthor() {
        return author;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getTags() {
        return tags;
    }


    @Override
    public String toString() {
        return "FlickerPublicItem{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", media=" + media +
                ", dateTaken='" + dateTaken + '\'' +
                ", description='" + description + '\'' +
                ", published='" + published + '\'' +
                ", author='" + author + '\'' +
                ", authorId='" + authorId + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }
}
