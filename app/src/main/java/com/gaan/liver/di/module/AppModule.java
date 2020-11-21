package com.gaan.liver.di.module;

import android.app.Application;
import android.content.Context;

import com.gaan.liver.R;
import com.gaan.liver.data.local.AppPreferencesHelper;
import com.gaan.liver.data.local.IAppPreferencesHelper;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.data.manager.UserDataManager;
import com.gaan.liver.data.remote.IAuthApi;
import com.gaan.liver.data.repository.AuthRepo;
import com.gaan.liver.util.rx.AppSchedulerProvider;
import com.gaan.liver.util.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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

    @Provides
    @Singleton
    static IAuthApi provideUserService(Retrofit retrofit) {
        return retrofit.create(IAuthApi.class);
    }

    @Provides
    @Singleton
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    AuthRepo provideAuthRepo(IAuthApi authApi){
        return new AuthRepo(authApi);
    }

}
