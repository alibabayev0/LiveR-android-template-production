package com.gaan.liver.data.model.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostFacebookLoginRequest {

    @Expose
    @SerializedName("fb_access_token")
    private String fbAccessToken;

    @Expose
    @SerializedName("fb_user_id")
    private String fbUserId;

    public PostFacebookLoginRequest(String fbUserId, String fbAccessToken) {
        this.fbUserId = fbUserId;
        this.fbAccessToken = fbAccessToken;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        PostFacebookLoginRequest that = (PostFacebookLoginRequest) object;

        if (fbUserId != null ? !fbUserId.equals(that.fbUserId) : that.fbUserId != null) {
            return false;
        }
        return fbAccessToken != null ? fbAccessToken.equals(that.fbAccessToken)
                : that.fbAccessToken == null;
    }

    @Override
    public int hashCode() {
        int result = fbUserId != null ? fbUserId.hashCode() : 0;
        return result;
    }

    public String getFbAccessToken() {
        return fbAccessToken;
    }

    public String getFbUserId() {
        return fbUserId;
    }
}