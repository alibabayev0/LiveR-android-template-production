package com.gaan.liver.data.remote;


import com.gaan.liver.data.model.api.request.FacebookLoginRequest;
import com.gaan.liver.data.model.api.request.GoogleLoginRequest;
import com.gaan.liver.data.model.api.request.ServerLoginRequest;
import com.gaan.liver.data.model.api.response.LoginResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IAuthApi {

    @POST(ApiConstants.FACEBOOK_API + "/${LOGIN_URL}")
    Single<LoginResponse> postFacebookApiCall(@Body FacebookLoginRequest facebookLoginRequest);

    @POST(ApiConstants.GOOGLE_API + "/${LOGIN_URL}")
    Single<LoginResponse> postGoogleApiCall(@Body GoogleLoginRequest googleLoginRequest);

    @POST("/${LOGIN_URL}")
    Single<LoginResponse> postLoginApiCall(@Body ServerLoginRequest serverLoginRequest);
}
