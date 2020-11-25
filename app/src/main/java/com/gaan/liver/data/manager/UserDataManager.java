package com.gaan.liver.data.manager;

import android.content.Context;

import com.gaan.liver.data.local.AppPreferencesHelper;
import com.gaan.liver.data.local.IAppPreferencesHelper;
import com.gaan.liver.data.model.pojo.LoggedStatus;

import javax.inject.Inject;

public class UserDataManager implements IUserDataManager  {
    private static final String TAG = "AppDataManager";

    Context mContext;

    private final IAppPreferencesHelper mPreferencesHelper;

    @Inject
    public UserDataManager(Context context, AppPreferencesHelper preferencesHelper) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
    }


    @Override
    public void updateUserInfo(String accessToken, Long userId, LoggedStatus loggedStatus, String userName, String email, String profileUrl) {
        setUserAccessToken(accessToken);
        setUserId(userId);
        setUserLoggedStatus(loggedStatus);
        setUserName(userName);
        setUserEmail(email);
        setUserProfilePic(profileUrl);

    }

    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(
                null,
                null,
                LoggedStatus.LOGGED_IN_MODE_LOGGED_OUT,
                null,
                null,
                null);
    }

    @Override
    public String getUserAccessToken() {
        return mPreferencesHelper.getUserAccessToken();
    }

    @Override
    public void setUserAccessToken(String accessToken) {
        mPreferencesHelper.setUserAccessToken(accessToken);
    }

    @Override
    public String getUserEmail() {
        return mPreferencesHelper.getUserEmail();
    }

    @Override
    public void setUserEmail(String email) {
        mPreferencesHelper.setUserEmail(email);
    }

    @Override
    public Long getUserId() {
        return mPreferencesHelper.getUserId();
    }

    @Override
    public void setUserId(Long userId) {
        mPreferencesHelper.setUserId(userId);
    }

    @Override
    public String getUserName() {
        return mPreferencesHelper.getUserName();
    }

    @Override
    public void setUserName(String username) {
        mPreferencesHelper.setUserName(username);
    }

    @Override
    public String getUserProfilePic() {
        return mPreferencesHelper.getUserProfilePic();
    }

    @Override
    public void setUserProfilePic(String urlPic) {
        mPreferencesHelper.setUserProfilePic(urlPic);
    }

    @Override
    public int getUserLoggedStatus() {
        return mPreferencesHelper.getUserLoggedStatus();
    }

    @Override
    public void setUserLoggedStatus(LoggedStatus status) {
        mPreferencesHelper.setUserLoggedStatus(status);
    }
}
