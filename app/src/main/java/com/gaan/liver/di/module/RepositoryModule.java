package com.gaan.liver.di.module;

import com.gaan.liver.data.remote.AuthService;
import com.gaan.liver.data.remote.EventService;
import com.gaan.liver.data.remote.UserService;
import com.gaan.liver.data.repository.AuthRepository;
import com.gaan.liver.data.repository.EventRepository;
import com.gaan.liver.data.repository.IAuthRepository;
import com.gaan.liver.data.repository.IEventRepository;
import com.gaan.liver.data.repository.IUserRepository;
import com.gaan.liver.data.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    IAuthRepository provideAuthRepository(AuthService authService){
        return new AuthRepository(authService);
    }

    @Provides
    @Singleton
    IUserRepository provideUserRepository(UserService userService){
        return new UserRepository(userService);
    }

    @Provides
    @Singleton
    IEventRepository provideEventRepository(EventService eventService){
        return new EventRepository(eventService);
    }
}
