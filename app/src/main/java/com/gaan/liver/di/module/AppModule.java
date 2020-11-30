package com.gaan.liver.di.module;

import android.app.Application;
import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.gaan.liver.data.constant.SensorConstants;
import com.gaan.liver.data.local.AppPreferencesHelper;
import com.gaan.liver.data.local.IAppPreferencesHelper;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.data.manager.UserDataManager;
import com.gaan.liver.ui.discover.DiscoverNearbyEventsAdapter;
import com.gaan.liver.util.rx.AppSchedulerProvider;
import com.gaan.liver.util.rx.SchedulerProvider;
import com.gaan.liver.util.sensors.GlobalSensor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.config.LocationAccuracy;
import io.nlopez.smartlocation.location.config.LocationParams;

@Module
public class AppModule {

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
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .build();
    }


    @Singleton
    @Provides
    SmartLocation.LocationControl provideLocationControl(Context context){
        LocationAccuracy trackingAccuracy = LocationAccuracy.HIGH;
        LocationParams.Builder builder = new LocationParams.Builder()
                .setAccuracy(trackingAccuracy)
                .setDistance(SensorConstants.LOCATION_TRACKING_DISTANCE)
                .setInterval(SensorConstants.LOCATION_TRACKING_INTERVAL);
        return SmartLocation.with(context)
                .location()
                .config(builder.build());
    }

    @Singleton
    @Provides
    GlobalSensor provideGlobalSensor(){
        return new GlobalSensor();
    }

    @BindingAdapter("imageUrl")
    public void setImageUrl(ImageView imageView, String url){
        Glide.with(imageView)
                .load(url)
                .into(imageView);
    }

    @Singleton
    @Provides
    public DiscoverNearbyEventsAdapter provideNearbyPlacesAdapter(Context context){
        return new DiscoverNearbyEventsAdapter(context);
    }


}
