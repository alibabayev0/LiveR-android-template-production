package com.gaan.liver.ui.auth.splash;


import android.view.View;

import androidx.databinding.BindingConversion;
import androidx.databinding.ObservableBoolean;

import com.gaan.liver.data.model.LoggedStatus;
import com.gaan.liver.data.repository.AuthRepo;
import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.rx.SchedulerProvider;

import javax.inject.Inject;

public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    public ObservableBoolean observableBoolean = new ObservableBoolean();

    @Inject
    public SplashViewModel(IUserDataManager iUserDataManager,SchedulerProvider schedulerProvider) {
        super(iUserDataManager,schedulerProvider);
    }

    public void startCheckStatusUser(){
        if (getUserDataManager().getUserLoggedStatus() == LoggedStatus.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
            getNavigator().openLoginActivity();
        } else {
            getNavigator().openArActivity();
        }
    }

    public int booleanToVisibility(Boolean value){
        return value ? View.VISIBLE : View.GONE;
    }

}
