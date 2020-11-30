package com.gaan.liver.ui.discover;

import com.gaan.liver.data.model.api.request.PostServerLoginRequest;
import com.gaan.liver.data.model.api.response.GetEventResponse;
import com.gaan.liver.data.model.pojo.LoggedStatus;
import com.gaan.liver.data.remote.EventService;
import com.gaan.liver.data.remote.UserService;
import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.DateUtil;
import com.gaan.liver.util.rx.SchedulerProvider;
import com.gaan.liver.util.sensors.SensorUtil;

import java.util.List;

import javax.inject.Inject;

import io.nlopez.smartlocation.SmartLocation;
import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

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
                    .flatMapPublisher(Flowable::fromIterable)
                    .map(res-> {
                        res.setDistance(res.distanceToPoint(location.getLatitude(),location.getLongitude()));
                        return res;
                    })
                    .toList()
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(response-> getNavigator().showNearbyEvents(response),
                               throwable -> getNavigator().errorNearbyEvents(throwable))
            );
        });
    }

}
