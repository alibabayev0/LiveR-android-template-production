package com.gaan.liver.ui.ar;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.gaan.liver.data.repository.IEventRepository;
import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.DateUtil;
import com.gaan.liver.util.rx.SchedulerProvider;
import com.gaan.liver.util.sensors.GlobalSensor;
import com.gaan.liver.util.sensors.SensorUtil;

import javax.inject.Inject;

import io.nlopez.smartlocation.SmartLocation;
import io.reactivex.Flowable;
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

    IEventRepository mEventRepository;

    // Mvvm rules ViewModel does'nt know about context inside viewmodel for lifecycle and principles
    // but viewmodel does not keeping the context using once for sensormanager.
    @Inject
    public ArViewModel(IEventRepository iEventRepository,SmartLocation.LocationControl locationControl,GlobalSensor globalSensor,Context context, IUserDataManager iUserDataManager, SchedulerProvider schedulerProvider) {
        super(iUserDataManager, schedulerProvider);
        this.globalSensor = globalSensor;
        this.locationControl = locationControl;
        mEventRepository = iEventRepository;
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
            getCompositeDisposable().add(mEventRepository
                    .getEventsByLocCall(getUserDataManager().getUserAccessToken(),
                                        location.getLatitude(),
                                        location.getLongitude(),
                                        location.getAltitude(),
                                        DateUtil.getTimeZone())
                    .flatMapPublisher(Flowable::fromIterable)
                    .map(res->{
                        res.setDegreeX(SensorUtil.horizontalDegreeToItem(res.getLat(),
                                                                        res.getLon(),
                                                                        location.getLatitude(),
                                                                        location.getLongitude()));
                        res.setDegreeY(SensorUtil.verticalDegreeToItem(res.getLat(),
                                                                    res.getLon(),
                                                                    location.getLatitude(),
                                                                    location.getLongitude(),
                                                                    res.getEle(),
                                                                    location.getAltitude())); // Altitude is wrong i have to write custom!!
                        return res;
                    })
                    .toList()
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(response-> {
//                        setIsLoading(false);
                        getNavigator().showItems(response);
                    },throwable -> {
//                        setIsLoading(false);
                        getNavigator().handlerShowItemsError(throwable);
                    })
            );
        });
    }

    // When activity starting we register sensors in sensor_manager and subscribing our custom degree variable of rxjava 2 namely
    // PublishSubject observable
    private void registerSensors(){
        mSensorManager.registerListener(globalSensor,mGravity,SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(globalSensor,mMagnetic,SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(globalSensor,mAccelerometr,SensorManager.SENSOR_DELAY_NORMAL);

        Disposable disposable = globalSensor.getSensorXYPublishSubject().subscribe(sensorXY->{
            getNavigator().setRangeOfView(sensorXY);
        });

        getCompositeDisposable().add(disposable);
    }

}
