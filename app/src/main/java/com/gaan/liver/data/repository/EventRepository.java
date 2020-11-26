package com.gaan.liver.data.repository;

import com.gaan.liver.data.model.api.request.PostEventRequest;
import com.gaan.liver.data.model.api.response.DeleteEventResponse;
import com.gaan.liver.data.model.api.response.GetEventResponse;
import com.gaan.liver.data.model.api.response.PostEventResponse;
import com.gaan.liver.data.model.api.response.PutEventResponse;
import com.gaan.liver.data.remote.EventService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class EventRepository implements IEventRepository{

    //NetworkService (Retrofit)
    private EventService mEventService;

    @Inject
    public EventRepository(EventService eventService){
        mEventService = eventService;
    }

    @Override
    public Single<GetEventResponse> getEventByIdCall(String token,String eventId){
        return mEventService.getEventByIdCall(token,eventId);
    }

    @Override
    public Single<List<GetEventResponse>> getEventsByLocCall(String token,String lat, String lon, String ele, String timezone){
        return mEventService.getEventsByLocCall(token,lat,lon,ele,timezone);
    }

    @Override
    public Single<PostEventResponse> postEvent(String token,PostEventRequest eventRequest){
        return mEventService.postEvent(token,eventRequest);
    }

    @Override
    public Single<DeleteEventResponse> deleteEventCall(String token,String eventId){
        return mEventService.deleteEventByIdCall(token,eventId);
    }

    @Override
    public Single<PutEventResponse> putEventCall(String token,String eventId){
        return mEventService.putEventByIdCall(token,eventId);
    }
}
