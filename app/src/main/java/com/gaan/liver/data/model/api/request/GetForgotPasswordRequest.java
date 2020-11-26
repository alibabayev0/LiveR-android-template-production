package com.gaan.liver.data.model.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetForgotPasswordRequest {
    @Expose
    @SerializedName("email")
    private String email_username_phone;

    public GetForgotPasswordRequest(String email_username_phone) {
        this.email_username_phone = email_username_phone;
    }

}
