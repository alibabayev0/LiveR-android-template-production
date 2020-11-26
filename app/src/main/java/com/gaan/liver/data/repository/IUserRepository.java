package com.gaan.liver.data.repository;

import com.gaan.liver.data.model.api.request.PutUserRequest;
import com.gaan.liver.data.model.api.response.DeleteUserResponse;
import com.gaan.liver.data.model.api.response.GetUserResponse;
import com.gaan.liver.data.model.api.response.PutUserResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IUserRepository {

    Single<List<GetUserResponse>> getUsersByLocCall(String token,String lat, String lon, String ele);

    Single<GetUserResponse> getUserByIdCall(String token,String userId);

    Single<PutUserResponse> putUserCall(String token,PutUserRequest putUserRequest);

    Single<DeleteUserResponse> deleteUserCall(String token);

}
