package com.gaan.liver.data.model.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GoogleLoginRequest {

    @Expose
    @SerializedName("google_user_id")
    private String googleUserId;

    @Expose
    @SerializedName("google_id_token")
    private String idToken;

    public GoogleLoginRequest(String googleUserId, String idToken) {
        this.googleUserId = googleUserId;
        this.idToken = idToken;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        GoogleLoginRequest that = (GoogleLoginRequest) object;

        if (googleUserId != null ? !googleUserId.equals(that.googleUserId)
                : that.googleUserId != null) {
            return false;
        }
        return idToken != null ? idToken.equals(that.idToken) : that.idToken == null;

    }

    @Override
    public int hashCode() {
        int result = googleUserId != null ? googleUserId.hashCode() : 0;
        return result;
    }

    public String getGoogleUserId() {
        return googleUserId;
    }

    public String getIdToken() {
        return idToken;
    }
}