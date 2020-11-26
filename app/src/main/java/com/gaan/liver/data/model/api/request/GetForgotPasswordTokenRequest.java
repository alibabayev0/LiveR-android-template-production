package com.gaan.liver.data.model.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetForgotPasswordTokenRequest {
    @Expose
    @SerializedName("otp")
    public String otp;

    @Expose
    @SerializedName("newPassword")
    public String newPassword;

    public GetForgotPasswordTokenRequest(String otp, String newPassword) {
        this.otp = otp;
        this.newPassword = newPassword;
    }
}
