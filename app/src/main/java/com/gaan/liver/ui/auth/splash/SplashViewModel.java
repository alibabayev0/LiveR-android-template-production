package com.gaan.liver.ui.auth.splash;


import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.rx.SchedulerProvider;

public class SplashViewModel extends BaseViewModel<SplashNavigator> {



    public SplashViewModel(IUserDataManager iUserDataManager,SchedulerProvider schedulerProvider) {
        super(iUserDataManager,schedulerProvider);
    }

    public void startCheckStatusUser(){

    }

}
