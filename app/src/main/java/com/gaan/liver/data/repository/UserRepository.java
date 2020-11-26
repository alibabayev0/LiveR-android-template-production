package com.gaan.liver.data.repository;

import com.gaan.liver.data.model.api.request.PutUserRequest;
import com.gaan.liver.data.model.api.response.DeleteUserResponse;
import com.gaan.liver.data.model.api.response.GetUserResponse;
import com.gaan.liver.data.model.api.response.PutUserResponse;
import com.gaan.liver.data.remote.UserService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class UserRepository implements IUserRepository {

    //NetworkService (Retrofit)
    private UserService mUserService;

    @Inject
    public UserRepository(UserService userService){
        mUserService = userService;
    }


    @Override
    public Single<List<GetUserResponse>> getUsersByLocCall(String token,String lat, String lon, String ele) {
        return mUserService.getUsersByLocCall(token,lat,lon,ele);
    }

    @Override
    public Single<GetUserResponse> getUserByIdCall(String token,String userId) {
        return mUserService.getUserByIdCall(token,userId);
    }

    @Override
    public Single<PutUserResponse> putUserCall(String token, PutUserRequest putUserRequest) {
        return mUserService.putUserCall(token,putUserRequest);
    }

    @Override
    public Single<DeleteUserResponse> deleteUserCall(String token) {
        return mUserService.deleteUserCall(token);
    }
}
