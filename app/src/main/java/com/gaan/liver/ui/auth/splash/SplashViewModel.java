package com.gaan.liver.ui.auth.splash;


import android.view.View;

import androidx.databinding.BindingConversion;
import androidx.databinding.ObservableBoolean;

import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.rx.SchedulerProvider;

public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    public ObservableBoolean observableBoolean = new ObservableBoolean();

    public SplashViewModel(IUserDataManager iUserDataManager,SchedulerProvider schedulerProvider) {
        super(iUserDataManager,schedulerProvider);
    }

    public void startCheckStatusUser(){

    }

    public int booleanToVisibility(Boolean value){
        return value ? View.VISIBLE : View.GONE;
    }

}
