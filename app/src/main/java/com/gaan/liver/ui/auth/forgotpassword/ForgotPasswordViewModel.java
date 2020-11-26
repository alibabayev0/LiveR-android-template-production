package com.gaan.liver.ui.auth.forgotpassword;

import com.gaan.liver.data.model.api.request.GetForgotPasswordRequest;
import com.gaan.liver.data.model.api.request.GetForgotPasswordTokenRequest;
import com.gaan.liver.data.model.api.request.PostServerLoginRequest;
import com.gaan.liver.data.model.pojo.LoggedStatus;
import com.gaan.liver.data.repository.IAuthRepository;
import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.logger.Logger;
import com.gaan.liver.util.rx.SchedulerProvider;

import javax.inject.Inject;

public class ForgotPasswordViewModel extends BaseViewModel<IForgotPasswordNavigator> {

    //Email Username or Phone number
    public String email;
    public String otp;
    public String newPassword;


    IAuthRepository mAuthRepository;

    @Inject
    public ForgotPasswordViewModel(IAuthRepository iAuthRepository,IUserDataManager iUserDataManager, SchedulerProvider schedulerProvider) {
        super(iUserDataManager, schedulerProvider);
        mAuthRepository = iAuthRepository;
    }

    public void forgotPassword(){
        getCompositeDisposable().add(mAuthRepository
                .getForgotPassword(new GetForgotPasswordRequest(email))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response-> {
                    setIsLoading(false);
                    getNavigator().showViewOnResponse();
                },throwable -> {
                    setIsLoading(false);
                    getNavigator().userNotFoundError(throwable);
                })
        );
    }

    public void changePassword(){
        getCompositeDisposable().add(mAuthRepository
                .getForgotPasswordTokenValidCall(new GetForgotPasswordTokenRequest(otp,newPassword))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response-> {
                    setIsLoading(false);
                    getNavigator().passwordSuccefullyChangedResponse();
                },throwable -> {
                    setIsLoading(false);
                    getNavigator().passwordChangingError(throwable);
                })
        );
    }

}
