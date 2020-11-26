package com.gaan.liver.di.module;

import com.gaan.liver.data.remote.AuthService;
import com.gaan.liver.data.remote.EventService;
import com.gaan.liver.data.remote.UserService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.gaan.liver.data.constant.ApiConstants.BASE_URL;
import static com.gaan.liver.data.constant.ApiConstants.FACEBOOK_API;
import static com.gaan.liver.data.constant.ApiConstants.GOOGLE_API;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    @Named("Server")
    static Retrofit provideRetrofitServer() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    @Named("Facebook")
    static Retrofit provideRetrofitFacebook() {
        return new Retrofit.Builder().baseUrl(FACEBOOK_API)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    @Named("Google")
    static Retrofit provideRetrofitGoogle() {
        return new Retrofit.Builder().baseUrl(GOOGLE_API)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static AuthService provideAuthService(@Named("Server") Retrofit retrofit) {
        return retrofit.create(AuthService.class);
    }

    @Singleton
    @Provides
    static EventService provideEventService(@Named("Server") Retrofit retrofit) {
        return retrofit.create(EventService.class);
    }

    @Singleton
    @Provides
    static UserService provideUserService(@Named("Server") Retrofit retrofit) {
        return retrofit.create(UserService.class);
    }
}
