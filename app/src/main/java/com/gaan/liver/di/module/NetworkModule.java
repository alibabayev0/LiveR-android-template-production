package com.gaan.liver.di.module;

import com.gaan.liver.data.remote.AuthService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.gaan.liver.data.constant.ApiConstants.BASE_URL;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static AuthService provideAuthService(Retrofit retrofit) {
        return retrofit.create(AuthService.class);
    }

}
