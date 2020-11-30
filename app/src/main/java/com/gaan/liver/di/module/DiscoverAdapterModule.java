package com.gaan.liver.di.module;

import android.app.Application;
import android.content.Context;

import com.gaan.liver.ui.discover.DiscoverNearbyEventsAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DiscoverAdapterModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Singleton
    @Provides
    public DiscoverNearbyEventsAdapter provideNearbyPlacesAdapter(Context context){
        return new DiscoverNearbyEventsAdapter(context);
    }
}
