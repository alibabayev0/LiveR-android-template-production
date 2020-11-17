package com.gaan.liver.data.local;

import android.content.Context;

import com.gaan.liver.data.model.LoggedStatus;
import com.orhanobut.hawk.Hawk;

import javax.inject.Inject;

public class AppPreferencesHelper implements IAppPreferencesHelper {
    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";

    private static final String PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL";

    private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";

    private static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";

    private static final String PREF_KEY_CURRENT_USER_PROFILE_PIC_URL = "PREF_KEY_CURRENT_USER_PROFILE_PIC_URL";

    private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";

    @Inject
    public AppPreferencesHelper() {
    }

    @Override
    public String getUserAccessToken() {
        return Hawk.get(PREF_KEY_ACCESS_TOKEN,null);
    }

    @Override
    public void setUserAccessToken(String accessToken) {
        Hawk.put(PREF_KEY_ACCESS_TOKEN,accessToken);
    }

    @Override
    public String getUserEmail() {
        return Hawk.get(PREF_KEY_CURRENT_USER_EMAIL,null);
    }

    @Override
    public void setUserEmail(String email) {
        Hawk.put(PREF_KEY_CURRENT_USER_EMAIL,email);
    }

    @Override
    public Long getUserId() {
        Long userId = Long.parseLong(Hawk.get(PREF_KEY_CURRENT_USER_ID,null));
        return userId == -1L ? null : userId;
    }

    @Override
    public void setUserId(Long userId) {
        long id = userId == null ? -1L : userId;
        Hawk.put(PREF_KEY_CURRENT_USER_ID,String.valueOf(id));
    }

    @Override
    public String getUserName() {
        return Hawk.get(PREF_KEY_CURRENT_USER_NAME,null);
    }

    @Override
    public void setUserName(String username) {
        Hawk.put(PREF_KEY_CURRENT_USER_NAME,username);
    }

    @Override
    public String getUserProfilePic() {
        return  Hawk.get(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL,null);
    }

    @Override
    public void setUserProfilePic(String urlPic) {
        Hawk.put(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL,urlPic);
    }

    @Override
    public int getUserLoggedStatus() {
        int status = Integer.parseInt(Hawk.get(PREF_KEY_USER_LOGGED_IN_MODE, "0"));
        return  status == 0 ? LoggedStatus.LOGGED_IN_MODE_LOGGED_OUT.getType() : status;
    }

    @Override
    public void setUserLoggedStatus(LoggedStatus status) {
        Hawk.put(PREF_KEY_USER_LOGGED_IN_MODE,status.getType());
    }
}
