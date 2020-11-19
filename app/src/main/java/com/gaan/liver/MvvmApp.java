package com.gaan.liver;

import android.app.Application;
import android.util.Log;

import com.gaan.liver.di.component.AppComponent;
import com.gaan.liver.di.component.DaggerAppComponent;
import com.gaan.liver.util.logger.Logger;
import com.orhanobut.hawk.Hawk;

import javax.inject.Inject;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;


public class MvvmApp extends Application {

    public AppComponent appComponent;

    @Inject
    CalligraphyConfig mCalligraphyConfig;

    @Override
    public void onCreate() {
        super.onCreate();

        Hawk.init(this).build();

        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();

        appComponent.inject(this);

        Logger.init();

        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .build()))
                .build());
    }
}
