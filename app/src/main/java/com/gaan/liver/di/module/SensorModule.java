package com.gaan.liver.di.module;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.gaan.liver.data.constant.SensorConstants;
import com.gaan.liver.util.sensors.GlobalSensor;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.config.LocationAccuracy;
import io.nlopez.smartlocation.location.config.LocationParams;

@Module
public class SensorModule {


    @Singleton
    @Provides
    @Named("SensorManager")
    SensorManager provideSensorManager(Context context){
        return (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
    }

    @Singleton
    @Provides
    @Named("GravitySensor")
    Sensor provideGravitySensor(SensorManager sensorManager){
        return sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
    }

    @Singleton
    @Provides
    @Named("MagneticSensor")
    Sensor provideMagneticSensor(SensorManager sensorManager){
        return sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
    }

    @Singleton
    @Provides
    @Named("AccelerometerSensor")
    Sensor provideAccelerometerSensor(SensorManager sensorManager){
        return sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Provides
    @Named("LocationControl")
    SmartLocation.LocationControl provideLocationControl(Context context){
        LocationAccuracy trackingAccuracy = LocationAccuracy.MEDIUM;
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
    @Named("GlobalSensor")
    GlobalSensor provideGlobalSensor(){
        return new GlobalSensor();
    }
}
