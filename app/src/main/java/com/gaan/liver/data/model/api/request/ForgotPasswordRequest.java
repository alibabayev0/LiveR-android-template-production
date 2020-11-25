package com.gaan.liver.data.model.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForgotPasswordRequest {
    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("username")
    private String username;

    @Expose
    @SerializedName("phoneNumber")
    private String phoneNumber;
}
