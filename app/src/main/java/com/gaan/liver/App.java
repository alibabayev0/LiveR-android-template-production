package com.gaan.liver;

import android.app.Application;

import com.gaan.liver.di.component.AppComponent;
import com.gaan.liver.di.component.DaggerAppComponent;
import com.gaan.liver.util.Logger;
import com.orhanobut.hawk.Hawk;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class App extends Application {

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

        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }
}
