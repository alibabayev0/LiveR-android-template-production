package com.gaan.liver.data.repository;

import com.gaan.liver.data.model.api.request.FacebookLoginRequest;
import com.gaan.liver.data.model.api.request.GoogleLoginRequest;
import com.gaan.liver.data.model.api.request.ServerLoginRequest;
import com.gaan.liver.data.model.api.request.ServerRegisterRequest;
import com.gaan.liver.data.model.api.response.LoginResponse;
import com.gaan.liver.data.model.api.response.RegisterResponse;
import com.gaan.liver.data.remote.AuthService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AuthRepository {

    private AuthService authApi;

    @Inject
    public AuthRepository(AuthService authApi) {
        this.authApi = authApi;
    }

    public Single<LoginResponse> postFacebookApiCall(FacebookLoginRequest facebookLoginRequest){
        return authApi.postFacebookApiCall(facebookLoginRequest);
    }

    public Single<LoginResponse> postGoogleApiCall(GoogleLoginRequest googleLoginRequest){
        return authApi.postGoogleApiCall(googleLoginRequest);
    }

    public Single<LoginResponse> postLoginApiCall(ServerLoginRequest serverLoginRequest){
        return authApi.postLoginApiCall(serverLoginRequest);
    }

    public Single<RegisterResponse> postRegisterCall(ServerRegisterRequest serverRegisterRequest){
        return authApi.postRegisterCall(serverRegisterRequest);
    }

}
