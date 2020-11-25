package com.gaan.liver.data.model.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostEventRequest {
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
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lon")
    @Expose
    private double lon;
    @SerializedName("categoryId")
    @Expose
    private Integer categoryId;
}
