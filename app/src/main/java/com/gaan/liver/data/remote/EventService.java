package com.gaan.liver.data.remote;

import com.gaan.liver.data.model.api.request.PostEventRequest;
import com.gaan.liver.data.model.api.response.DeleteEventResponse;
import com.gaan.liver.data.model.api.response.GetEventResponse;
import com.gaan.liver.data.model.api.response.PostEventResponse;
import com.gaan.liver.data.model.api.response.PutEventResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.gaan.liver.data.constant.ApiConstants.EVENT_SERVICE_DELETE_EVENT_BY_ID_URL;
import static com.gaan.liver.data.constant.ApiConstants.EVENT_SERVICE_GET_EVENT_BY_ID_URL;
import static com.gaan.liver.data.constant.ApiConstants.EVENT_SERVICE_GET_EVENT_BY_LOC_URL;
import static com.gaan.liver.data.constant.ApiConstants.EVENT_SERVICE_POST_EVENT_URL;
import static com.gaan.liver.data.constant.ApiConstants.EVENT_SERVICE_PUT_EVENT_BY_ID_URL;

public interface EventService {
    @GET(EVENT_SERVICE_GET_EVENT_BY_ID_URL)
    Single<GetEventResponse> getEventByIdCall(@Header("Authorization") String token,
                                              @Path("eventId") String eventId);

    @GET(EVENT_SERVICE_GET_EVENT_BY_LOC_URL)
    Single<List<GetEventResponse>> getEventsByLocCall(@Header("Authorization") String token,
                                                      @Query("lat") double lat,
                                                      @Query("lon") double lon,
                                                      @Query("ele") double ele,
                                                      @Query("timezone") String timezone);

    @POST(EVENT_SERVICE_POST_EVENT_URL)
    Single<PostEventResponse> postEvent(@Header("Authorization") String token,
                                        @Body PostEventRequest eventRequest);

    @DELETE(EVENT_SERVICE_DELETE_EVENT_BY_ID_URL)
    Single<DeleteEventResponse> deleteEventByIdCall(@Header("Authorization") String token,
                                                    @Path("eventId") String eventId);

    @PUT(EVENT_SERVICE_PUT_EVENT_BY_ID_URL)
    Single<PutEventResponse> putEventByIdCall(@Header("Authorization") String token,
                                              @Path("eventId") String eventId);
}
