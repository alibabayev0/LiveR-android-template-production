package com.gaan.liver.ui.auth.register;

import com.gaan.liver.data.model.api.request.ServerRegisterRequest;
import com.gaan.liver.data.repository.AuthRepository;
import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.logger.Logger;
import com.gaan.liver.util.rx.SchedulerProvider;

import javax.inject.Inject;

public class RegisterViewModel extends BaseViewModel<IRegisterNavigator> {

    public String username = "";
    public String password = "";
    public String cPassword = "";
    public String email = "";

    private AuthRepository authRepository;

    @Inject
    public RegisterViewModel(AuthRepository authRepository, IUserDataManager iUserDataManager, SchedulerProvider schedulerProvider) {
        super(iUserDataManager, schedulerProvider);
        this.authRepository = authRepository;
    }

    public void register(){
        if(!password.equals(cPassword)){
            Logger.d("RegisterViewModel", "Password is not match");
            return;
        }
        setIsLoading(true);
        getCompositeDisposable().add(authRepository.postRegisterCall
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
