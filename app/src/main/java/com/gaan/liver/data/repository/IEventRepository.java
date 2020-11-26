package com.gaan.liver.data.repository;

import com.gaan.liver.data.model.api.request.PostEventRequest;
import com.gaan.liver.data.model.api.response.DeleteEventResponse;
import com.gaan.liver.data.model.api.response.GetEventResponse;
import com.gaan.liver.data.model.api.response.PostEventResponse;
import com.gaan.liver.data.model.api.response.PutEventResponse;

import java.util.List;

import io.reactivex.Single;

public interface IEventRepository {
    Single<GetEventResponse> getEventByIdCall(String token,String eventId);

    Single<List<GetEventResponse>> getEventsByLocCall(String token,String lat, String lon, String ele, String timezone);

    Single<PostEventResponse> postEvent(String token,PostEventRequest eventRequest);

    Single<DeleteEventResponse> deleteEventCall(String token,String eventId);

    Single<PutEventResponse> putEventCall(String token,String eventId);
}
