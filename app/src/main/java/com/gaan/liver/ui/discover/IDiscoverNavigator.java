package com.gaan.liver.ui.discover;

import com.gaan.liver.data.model.api.response.GetEventResponse;
import com.gaan.liver.data.model.api.response.GetUserResponse;

import java.util.List;

public interface IDiscoverNavigator {
    void openArActivity();
    void openMessengerActivity();
    void openProfileActivity();

    void showNearbyPlaces();
    void showNearbyEvents(List<GetEventResponse> getEventResponseList);
    void showNearbyPeople(List<GetUserResponse> getUserResponseList);

    void errorNearbyPlaces(Throwable throwable);
    void errorNearbyEvents(Throwable throwable);
    void errorNearbyPeople(Throwable throwable);

}
