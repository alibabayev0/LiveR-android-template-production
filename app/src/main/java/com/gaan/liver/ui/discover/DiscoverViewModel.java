package com.gaan.liver.ui.discover;

import com.gaan.liver.data.model.api.request.PostServerLoginRequest;
import com.gaan.liver.data.model.pojo.LoggedStatus;
import com.gaan.liver.data.remote.EventService;
import com.gaan.liver.data.remote.UserService;
import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.DateUtil;
import com.gaan.liver.util.rx.SchedulerProvider;
import com.gaan.liver.util.sensors.SensorUtil;

import javax.inject.Inject;

import io.nlopez.smartlocation.SmartLocation;
import io.reactivex.Flowable;

public class DiscoverViewModel extends BaseViewModel<IDiscoverNavigator> {

    UserService mUserService;
    EventService mEventService;
    SmartLocation.LocationControl mLocationControl;

    @Inject
    public DiscoverViewModel(SmartLocation.LocationControl locationControl,UserService userService, EventService eventService, IUserDataManager iUserDataManager, SchedulerProvider schedulerProvider) {
        super(iUserDataManager, schedulerProvider);
        mEventService = eventService;
        mUserService = userService;
        mLocationControl = locationControl;
        searchNearbyPlaces();
    }

    public void searchNearbyPlaces(){
        mLocationControl.start(location -> {
            getCompositeDisposable().add(mEventService
                            .getEventsByLocCall(getUserDataManager().getUserAccessToken(),
                                    location.getLatitude(),
                                    location.getLongitude(),
                                    location.getAltitude(),
                                    DateUtil.getTimeZone())
                            .subscribeOn(getSchedulerProvider().io())
                            .observeOn(getSchedulerProvider().ui())
                            .subscribe(response-> {
                                getNavigator().showNearbyEvents(response);
                            },throwable -> {
                                getNavigator().errorNearbyEvents(throwable);
                            })
            );
        });
    }

}
