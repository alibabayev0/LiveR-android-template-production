package com.gaan.liver.data.repository;

import com.gaan.liver.data.model.api.FacebookLoginRequest;
import com.gaan.liver.data.model.api.GoogleLoginRequest;
import com.gaan.liver.data.model.api.LoginRequest;
import com.gaan.liver.data.remote.IAuthApi;

import javax.inject.Inject;

import io.reactivex.Single;

public class AuthRepo {

    private IAuthApi authApi;

    @Inject
    public AuthRepo(IAuthApi authApi) {
        this.authApi = authApi;
    }

    public Single<String> postFacebookApiCall(FacebookLoginRequest facebookLoginRequest){
        return authApi.postFacebookApiCall(facebookLoginRequest);
    }

    public Single<String> postGoogleApiCall(GoogleLoginRequest googleLoginRequest){
        return authApi.postGoogleApiCall(googleLoginRequest);
    }

    public Single<String> postLoginApiCall(LoginRequest loginRequest){
        return authApi.postLoginApiCall(loginRequest);
    }

}
