package com.gaan.liver.data.remote;

import com.gaan.liver.data.model.api.request.PutUserRequest;
import com.gaan.liver.data.model.api.response.DeleteUserResponse;
import com.gaan.liver.data.model.api.response.PutUserResponse;
import com.gaan.liver.data.model.api.response.GetUserResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.gaan.liver.data.constant.ApiConstants.USER_SERVICE_DELETE_USER_BY_ID_URL;
import static com.gaan.liver.data.constant.ApiConstants.USER_SERVICE_GET_USER_BY_ID_URL;
import static com.gaan.liver.data.constant.ApiConstants.USER_SERVICE_GET_USER_BY_LOC_URL;
import static com.gaan.liver.data.constant.ApiConstants.USER_SERVICE_PUT_USER_BY_ID_URL;

public interface UserService {

//    It is so big data, if i use it there could be memoryleak or network problem. It is example:
//    @GET("${USER_URL}")
//    Single<List<UserResponse>> getUsersCall();

    @GET(USER_SERVICE_GET_USER_BY_LOC_URL)
    Single<List<GetUserResponse>> getUsersByLocCall(@Header("Authorization") String token,
                                                    @Query("lat") String lat,
                                                    @Query("lon") String lon,
                                                    @Query("ele") String ele);

    @GET(USER_SERVICE_GET_USER_BY_ID_URL)
    Single<GetUserResponse> getUserByIdCall(@Header("Authorization") String token,
                                            @Path("userId") String userId);

    @PUT(USER_SERVICE_PUT_USER_BY_ID_URL)
    Single<PutUserResponse> putUserCall(@Header("Authorization") String token,
                                        @Body PutUserRequest putUserRequest);

    //DELETE User By Header Token
    @DELETE(USER_SERVICE_DELETE_USER_BY_ID_URL)
    Single<DeleteUserResponse> deleteUserCall(@Header("Authorization") String token);

}
