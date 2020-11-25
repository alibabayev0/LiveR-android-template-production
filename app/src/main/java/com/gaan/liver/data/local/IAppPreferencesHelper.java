package com.gaan.liver.data.local;

import com.gaan.liver.data.model.pojo.LoggedStatus;

public interface IAppPreferencesHelper {
    String getUserAccessToken();

    void setUserAccessToken(String accessToken);

    String getUserEmail();

    void setUserEmail(String email);

    Long getUserId();

    void setUserId(Long userId);

    String getUserName();

    void setUserName(String username);

    String getUserProfilePic();

    void setUserProfilePic(String urlPic);

    int getUserLoggedStatus();

    void setUserLoggedStatus(LoggedStatus status);
}
