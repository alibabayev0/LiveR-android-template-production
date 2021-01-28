package com.gaan.liver.ui.auth.login;


import com.gaan.liver.data.model.pojo.LoggedStatus;
import com.gaan.liver.data.model.api.request.PostFacebookLoginRequest;
import com.gaan.liver.data.model.api.request.PostGoogleLoginRequest;
import com.gaan.liver.data.model.api.request.PostServerLoginRequest;
import com.gaan.liver.data.repository.AuthRepository;
import com.gaan.liver.data.repository.IAuthRepository;
import com.gaan.liver.data.repository.IUserRepository;
import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.rx.SchedulerProvider;

import javax.inject.Inject;

public class LoginViewModel extends BaseViewModel<ILoginNavigator> {

    public String username;
    public String password;

    IAuthRepository mAuthRepository;

    @Inject
    public LoginViewModel(IAuthRepository iAuthRepository, IUserDataManager iUserDataManager, SchedulerProvider schedulerProvider) {
        super(iUserDataManager, schedulerProvider);
        mAuthRepository = iAuthRepository;
    }

    public void checkUserExist(){
        if(getUserDataManager().getUserLoggedStatus() != LoggedStatus.LOGGED_IN_MODE_LOGGED_OUT.getType());
        {
            getNavigator().changeViewToUserExist(getUserDataManager().getUserName(),getUserDataManager().getUserProfilePic());
        }
    }

    public void forgotPassword(){
        getNavigator().openForgotPasswordActivity();
    }

    public void login(){
        setIsLoading(true);
        getCompositeDisposable().add(mAuthRepository
                .postLoginApiCall(new PostServerLoginRequest(username,password))
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
                .postFacebookApiCall(new PostFacebookLoginRequest(fbId,accessToken))
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
                .postGoogleApiCall(new PostGoogleLoginRequest(googleUserId,idToken))
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