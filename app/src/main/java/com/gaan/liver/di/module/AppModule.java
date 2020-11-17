package com.gaan.liver.di.module;

import android.app.Application;
import android.content.Context;

import com.gaan.liver.data.local.AppPreferencesHelper;
import com.gaan.liver.data.local.IAppPreferencesHelper;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.data.manager.UserDataManager;
import com.gaan.liver.util.rx.AppSchedulerProvider;
import com.gaan.liver.util.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Module
public class AppModule {

//    @Provides
//    String provideApiKey() {
//        return BuildConfig.API_KEY; // Change Here ---> API_KEY
//    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
//                .setFontAttrId(R.attr.fontPath)
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    IAppPreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @Singleton
    IUserDataManager provideUserDataManager(UserDataManager userDataManager) {
        return userDataManager;
    }

}
