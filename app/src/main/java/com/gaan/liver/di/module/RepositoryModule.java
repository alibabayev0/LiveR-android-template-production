package com.gaan.liver.di.module;

import com.gaan.liver.data.remote.IAuthApi;
import com.gaan.liver.data.repository.AuthRepo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    AuthRepo provideAuthRepo(IAuthApi authApi){
        return new AuthRepo(authApi);
    }
}
