package com.gaan.liver.data.repository;

import com.gaan.liver.data.model.api.request.PostEventRequest;
import com.gaan.liver.data.model.api.response.DeleteEventResponse;
import com.gaan.liver.data.model.api.response.EventResponse;
import com.gaan.liver.data.model.api.response.PostEventResponse;
import com.gaan.liver.data.model.api.response.PutEventResponse;
import com.gaan.liver.data.remote.EventService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Singleton
public class EventRepository {

    private EventService mEventService;

    @Inject
    public EventRepository(EventService eventService){
        mEventService = eventService;
    }

    Single<EventResponse> getEventByIdCall(String eventId){
        return mEventService.getEventByIdCall(eventId);
    }

    Single<List<EventResponse>> getEventByLocCall(String lat, String lon, String ele, String timezone){
        return mEventService.getEventByLocCall(lat,lon,ele,timezone);
    }

    Single<PostEventResponse> postEvent(PostEventRequest eventRequest){
        return mEventService.postEvent(eventRequest);
    }

    Single<DeleteEventResponse> deleteEventByIdCall(String eventId){
        return mEventService.deleteEventByIdCall(eventId);
    }

    Single<PutEventResponse> putEventByIdCall(String eventId){
        return mEventService.putEventByIdCall(eventId);
    }
}
