package com.gaan.liver.ui.auth.register;

import com.gaan.liver.data.model.LoggedStatus;
import com.gaan.liver.data.model.api.request.FacebookLoginRequest;
import com.gaan.liver.data.model.api.request.ServerRegisterRequest;
import com.gaan.liver.data.repository.AuthRepo;
import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.logger.Logger;
import com.gaan.liver.util.rx.SchedulerProvider;

public class RegisterViewModel extends BaseViewModel<IRegisterNavigator> {

    public String username = "";
    public String password = "";
    public String cPassword = "";
    public String email = "";

    private AuthRepo authRepo;

    public RegisterViewModel(AuthRepo authRepo,IUserDataManager iUserDataManager, SchedulerProvider schedulerProvider) {
        super(iUserDataManager, schedulerProvider);
        this.authRepo = authRepo;
    }

    public void register(){
        if(!password.equals(cPassword)){
            Logger.d("RegisterViewModel", "Password is not match");
            return;
        }
        setIsLoading(true);
        getCompositeDisposable().add(authRepo.postRegisterCall
                        (new ServerRegisterRequest(username,email,password))
                        .doOnSuccess(response-> Logger.d("TAG",response.toString()))
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(response-> {
                            setIsLoading(false);
                            getNavigator().openArActivity();
                        },throwable -> {
                            setIsLoading(false);
                            getNavigator().handleError(throwable);
                        }));
    }
}
