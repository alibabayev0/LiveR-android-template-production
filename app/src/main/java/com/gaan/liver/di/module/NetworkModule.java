package com.gaan.liver.di.module;

import com.gaan.liver.data.remote.ApiConstants;
import com.gaan.liver.data.remote.IAuthApi;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {


//    @Provides
//    @Singleton
//    OkHttpClient provideOkHttpClient() {
//        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
//        okHttpClient.connectTimeout(ApiConstants.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
//        okHttpClient.readTimeout(ApiConstants.READ_TIMEOUT, TimeUnit.MILLISECONDS);
//        okHttpClient.writeTimeout(ApiConstants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS);
//        okHttpClient.addInterceptor(new RequestInterceptor());
//        okHttpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
//        return okHttpClient.build();
//    }
//
//    @Provides
//    @Singleton
//    ApiService provideRetrofit(OkHttpClient okHttpClient) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(ApiConstants.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
//                .build();
//
//        return retrofit.create(ApiService.class);
//    }

    @Provides
    @Singleton
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    static IAuthApi provideUserService(Retrofit retrofit) {
        return retrofit.create(IAuthApi.class);
    }
}
