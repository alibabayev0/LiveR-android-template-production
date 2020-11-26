package com.gaan.liver.data.model.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PutUserRequest {
    @SerializedName("firstname")
    @Expose
    private String firstname;

    @SerializedName("lastname")
    @Expose
    private String lastname;

    @SerializedName("bio")
    @Expose
    private String bio;

    @SerializedName("imagePath")
    @Expose
    private String imagePath;


    public PutUserRequest(String firstname, String lastname, String bio, String imagePath) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.bio = bio;
        this.imagePath = imagePath;
    }
}
