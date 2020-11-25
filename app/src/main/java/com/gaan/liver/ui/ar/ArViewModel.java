package com.gaan.liver.ui.ar;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.logger.Logger;
import com.gaan.liver.util.rx.SchedulerProvider;
import com.gaan.liver.util.sensors.GlobalSensor;

import javax.inject.Inject;

import io.nlopez.smartlocation.SmartLocation;
import io.reactivex.disposables.Disposable;

public class ArViewModel extends BaseViewModel<ArNavigator>  {
    //Hardware Sensors (We cannt inject from readonly files)
    Sensor mGravity;
    Sensor mMagnetic;
    Sensor mAccelerometr;
    SensorManager mSensorManager;

    //Custom Sensor Listener
    GlobalSensor globalSensor;

    //Third party library
    SmartLocation.LocationControl locationControl;

    // Mvvm rules ViewModel does'nt know about context inside viewmodel for lifecycle and principles
    // but viewmodel does not keeping the context using once for sensormanager.
    @Inject
    public ArViewModel(SmartLocation.LocationControl locationControl,GlobalSensor globalSensor,Context context, IUserDataManager iUserDataManager, SchedulerProvider schedulerProvider) {
        super(iUserDataManager, schedulerProvider);
        this.globalSensor = globalSensor;
        this.locationControl = locationControl;
        initSensors(context);
    }

    public void startSearching(){
        registerSensors();
        initLocation();
    }
    
    public void stopSearching(){
        finalizeSensor();
        finalizeLocation();
    }

    private void finalizeSensor() {
        mSensorManager.unregisterListener(globalSensor);
    }

    private void finalizeLocation() {
        locationControl.stop();
    }

    //Initializa sensors for Phone degree in real life x,y,z.
    private void initSensors(Context context) {
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        mGravity = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        mMagnetic = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mAccelerometr =  mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    //Initialize location for take close objects from api.
    private void initLocation() {
        locationControl.start(location -> {
            Logger.d(location.getLatitude() + " " + location.getLongitude());
        });
    }

    // When activity starting we register sensors in sensor_manager and subscribing our custom degree variable of rxjava 2 namely
    // PublishSubject observable
    private void registerSensors(){
        mSensorManager.registerListener(globalSensor,mGravity,SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(globalSensor,mMagnetic,SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(globalSensor,mAccelerometr,SensorManager.SENSOR_DELAY_NORMAL);

        Disposable disposable = globalSensor.getSensorXYPublishSubject().subscribe(s->
            Logger.d(s.getHorizontalDegree() + " " + s.getVerticalDegree())
        );

        getCompositeDisposable().add(disposable);
    }

}
