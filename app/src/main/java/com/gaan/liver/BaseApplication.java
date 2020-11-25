package com.gaan.liver;

import android.app.Application;
import android.util.Log;

import com.gaan.liver.di.component.AppComponent;
import com.gaan.liver.di.component.DaggerAppComponent;
import com.gaan.liver.util.logger.Logger;
import com.orhanobut.hawk.Hawk;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;



public class BaseApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        Hawk.init(this).build();

        Logger.init();


    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
