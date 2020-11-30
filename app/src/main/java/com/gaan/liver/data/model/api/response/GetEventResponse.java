package com.gaan.liver.data.model.api.response;

import android.location.Location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetEventResponse {
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
    @SerializedName("picturePath")
    @Expose
    private String picture;
    @SerializedName("coverPath")
    @Expose
    private String cover;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lon")
    @Expose
    private double lon;
    @SerializedName("ele")
    @Expose
    private double ele;
    @SerializedName("categoryId")
    @Expose
    private Integer categoryId;

    private double degreeX;
    private double degreeY;
    private double mDistance;

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

    public double getEle() {
        return ele;
    }

    public double getDegreeX() {
        return degreeX;
    }

    public void setDegreeX(double degreeX) {
        this.degreeX = degreeX;
    }

    public double getDegreeY() {
        return degreeY;
    }

    public void setDegreeY(double degreeY) {
        this.degreeY = degreeY;
    }

    public double getDistance() {
        return mDistance;
    }

    public void setDistance(double distance) {
        this.mDistance = distance;
    }

    public double distanceToPoint(double lat, double lon){
        Location start = new Location("start");
        start.setLatitude(getLat());
        start.setLongitude(getLon());

        Location dest = new Location("dest");
        dest.setLatitude(lat);
        dest.setLongitude(lon);

        return start.distanceTo(dest);
    }
}
