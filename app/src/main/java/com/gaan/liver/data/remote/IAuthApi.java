package com.gaan.liver.data.remote;


import com.gaan.liver.data.model.api.FacebookLoginRequest;
import com.gaan.liver.data.model.api.GoogleLoginRequest;
import com.gaan.liver.data.model.api.LoginRequest;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IAuthApi {

    @POST(ApiConstants.FACEBOOK_API + "/${LOGIN_URL}")
    Single<String> postFacebookApiCall(@Body FacebookLoginRequest facebookLoginRequest);

    @POST(ApiConstants.GOOGLE_API + "/${LOGIN_URL}")
    Single<String> postGoogleApiCall(@Body GoogleLoginRequest googleLoginRequest);

    @POST("/${LOGIN_URL}")
    Single<String> postLoginApiCall(@Body LoginRequest loginRequest);
}
