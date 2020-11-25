package com.gaan.liver.data.model.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForgotPasswordTokenRequest {
    @Expose
    @SerializedName("token")
    public String token;

    @Expose
    @SerializedName("newPassword")
    public String newPassword;
}
