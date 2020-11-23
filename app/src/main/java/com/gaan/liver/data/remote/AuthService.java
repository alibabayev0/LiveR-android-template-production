package com.gaan.liver.data.remote;


import com.gaan.liver.data.model.api.request.FacebookLoginRequest;
import com.gaan.liver.data.model.api.request.GoogleLoginRequest;
import com.gaan.liver.data.model.api.request.ServerLoginRequest;
import com.gaan.liver.data.model.api.request.ServerRegisterRequest;
import com.gaan.liver.data.model.api.response.LoginResponse;
import com.gaan.liver.data.model.api.response.RegisterResponse;

import javax.inject.Singleton;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Singleton
public interface AuthService {

    @POST("/${LOGIN_URL}")
    Single<LoginResponse> postFacebookApiCall(@Body FacebookLoginRequest facebookLoginRequest);

    @POST("/${LOGIN_URL}")
    Single<LoginResponse> postGoogleApiCall(@Body GoogleLoginRequest googleLoginRequest);

    @POST("/${LOGIN_URL}")
    Single<LoginResponse> postLoginApiCall(@Body ServerLoginRequest serverLoginRequest);

    @POST("/${LOGIN_URL}")
    Single<RegisterResponse> postRegisterCall(@Body ServerRegisterRequest serverRegisterRequest);
}
