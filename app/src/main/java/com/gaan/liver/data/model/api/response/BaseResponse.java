package com.gaan.liver.data.model.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponse {
    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("status_code")
    private int status_code;

    public String getMessage() {
        return message;
    }

    public int getStatus_code() {
        return status_code;
    }
}
