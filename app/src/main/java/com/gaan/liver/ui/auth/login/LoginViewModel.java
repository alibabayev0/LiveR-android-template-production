package com.gaan.liver.ui.auth.login;


import com.gaan.liver.data.model.LoggedStatus;
import com.gaan.liver.data.model.api.request.FacebookLoginRequest;
import com.gaan.liver.data.model.api.request.GoogleLoginRequest;
import com.gaan.liver.data.model.api.request.ServerLoginRequest;
import com.gaan.liver.data.repository.AuthRepository;
import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.rx.SchedulerProvider;

import javax.inject.Inject;

public class LoginViewModel extends BaseViewModel<ILoginNavigator> {

    public String username;
    public String password;

    //DEPENDENCY INJECTION MISSING, I WILL UPDATE..
    @Inject
    AuthRepository mAuthRepository;

    @Inject
    public LoginViewModel(IUserDataManager iUserDataManager, SchedulerProvider schedulerProvider) {
        super(iUserDataManager, schedulerProvider);
    }

    public void login(){
        setIsLoading(true);
        getCompositeDisposable().add(mAuthRepository
                .postLoginApiCall(new ServerLoginRequest(username,password))
                .doOnSuccess(response-> getUserDataManager()
                        .updateUserInfo(
                                response.getAccessToken(),
                                response.getUserId(),
                                LoggedStatus.LOGGED_IN_MODE_SERVER,
                                response.getUserName(),
                                response.getUserEmail(),
                                response.getServerProfilePicUrl()
                                ))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response-> {
                    setIsLoading(false);
                    getNavigator().openArActivity();
                },throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                })
        );
    }

    public void onFbLoginClick(String fbId,String accessToken){
        setIsLoading(true);
        getCompositeDisposable().add(mAuthRepository
                .postFacebookApiCall(new FacebookLoginRequest(fbId,accessToken))
                .doOnSuccess(response-> getUserDataManager()
                        .updateUserInfo(
                                response.getAccessToken(),
                                response.getUserId(),
                                LoggedStatus.LOGGED_IN_MODE_SERVER,
                                response.getUserName(),
                                response.getUserEmail(),
                                response.getFbProfilePicUrl()
                        ))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response-> {
                    setIsLoading(false);
                    getNavigator().openArActivity();
                },throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                })
        );
    }

    public void onGoogleLoginClick(String googleUserId,String idToken){
        setIsLoading(true);
        getCompositeDisposable().add(mAuthRepository
                .postGoogleApiCall(new GoogleLoginRequest(googleUserId,idToken))
                .doOnSuccess(response-> getUserDataManager()
                        .updateUserInfo(
                                response.getAccessToken(),
                                response.getUserId(),
                                LoggedStatus.LOGGED_IN_MODE_SERVER,
                                response.getUserName(),
                                response.getUserEmail(),
                                response.getGoogleProfilePicUrl()
                        ))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response-> {
                    setIsLoading(false);
                    getNavigator().openArActivity();
                },throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                })
        );
    }
}