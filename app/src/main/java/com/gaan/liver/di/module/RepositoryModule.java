package com.gaan.liver.di.module;

import com.gaan.liver.data.remote.AuthService;
import com.gaan.liver.data.repository.AuthRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    AuthRepository authRepo(AuthService authService){
        return new AuthRepository(authService);
    }

}
