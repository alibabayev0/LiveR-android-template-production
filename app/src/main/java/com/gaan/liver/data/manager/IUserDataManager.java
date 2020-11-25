package com.gaan.liver.data.manager;

import com.gaan.liver.data.local.IAppPreferencesHelper;
import com.gaan.liver.data.model.pojo.LoggedStatus;

public interface IUserDataManager extends IAppPreferencesHelper {

    void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedStatus loggedStatus,
            String userName,
            String email,
            String profileUrl);

    void setUserAsLoggedOut();

}
