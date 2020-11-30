package com.gaan.liver.di.module;

import com.gaan.liver.data.local.AppPreferencesHelper;
import com.gaan.liver.data.local.IAppPreferencesHelper;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.data.manager.UserDataManager;
import com.gaan.liver.util.rx.AppSchedulerProvider;
import com.gaan.liver.util.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.inflationx.calligraphy3.CalligraphyConfig;

@Module
public class BaseAppModule {
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

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .build();
    }

}
