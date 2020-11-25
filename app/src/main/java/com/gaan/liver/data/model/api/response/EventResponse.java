package com.gaan.liver.data.model.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventResponse {
    @SerializedName("_id")
    @Expose
    private String _id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("hashTag")
    @Expose
    private String hashtag;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("cover")
    @Expose
    private String cover;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lon")
    @Expose
    private double lon;
    @SerializedName("categoryId")
    @Expose
    private Integer categoryId;

    public String get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getHashtag() {
        return hashtag;
    }

    public String getPicture() {
        return picture;
    }

    public String getCover() {
        return cover;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public Integer getCategoryId() {
        return categoryId;
    }
}
