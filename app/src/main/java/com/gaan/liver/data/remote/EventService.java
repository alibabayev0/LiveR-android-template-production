package com.gaan.liver.data.remote;

import com.gaan.liver.data.model.api.request.PostEventRequest;
import com.gaan.liver.data.model.api.response.DeleteEventResponse;
import com.gaan.liver.data.model.api.response.EventResponse;
import com.gaan.liver.data.model.api.response.PostEventResponse;
import com.gaan.liver.data.model.api.response.PutEventResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EventService {
    @GET("${EVENT_URL}/{eventId}")
    Single<EventResponse> getEventByIdCall(@Path("eventId") String eventId);

    @GET("${EVENT_URL}")
    Single<List<EventResponse>> getEventByLocCall(@Query("lat") String lat,
                                               @Query("lon") String lon,
                                               @Query("ele") String ele,
                                               @Query("timezone") String timezone);

    @POST("${EVENT_URL}")
    Single<PostEventResponse> postEvent(@Body PostEventRequest eventRequest);

    @DELETE("${EVENT_URL}/{eventId}")
    Single<DeleteEventResponse> deleteEventByIdCall(@Path("eventId") String eventId);

    @PUT("${EVENT_URL}/{eventId}")
    Single<PutEventResponse> putEventByIdCall(@Path("eventId") String eventId);
}
