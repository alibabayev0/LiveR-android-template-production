package com.gaan.liver.data.repository;

import com.gaan.liver.data.model.api.request.PostFacebookLoginRequest;
import com.gaan.liver.data.model.api.request.GetForgotPasswordRequest;
import com.gaan.liver.data.model.api.request.GetForgotPasswordTokenRequest;
import com.gaan.liver.data.model.api.request.PostGoogleLoginRequest;
import com.gaan.liver.data.model.api.request.PostServerLoginRequest;
import com.gaan.liver.data.model.api.request.PostServerRegisterRequest;
import com.gaan.liver.data.model.api.response.GetForgotPasswordResponse;
import com.gaan.liver.data.model.api.response.GetForgotPasswordTokenResponse;
import com.gaan.liver.data.model.api.response.PostLoginResponse;
import com.gaan.liver.data.model.api.response.PostRegisterResponse;
import com.gaan.liver.data.remote.AuthService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AuthRepository implements IAuthRepository{

    //NetworkService (Retrofit)
    private AuthService authApi;

    @Inject
    public AuthRepository(AuthService authApi) {
        this.authApi = authApi;
    }

    @Override
    public Single<PostLoginResponse> postFacebookApiCall(PostFacebookLoginRequest postFacebookLoginRequest){
        return authApi.postFacebookApiCall(postFacebookLoginRequest);
    }

    @Override
    public Single<PostLoginResponse> postGoogleApiCall(PostGoogleLoginRequest postGoogleLoginRequest){
        return authApi.postGoogleApiCall(postGoogleLoginRequest);
    }

    @Override
    public Single<PostLoginResponse> postLoginApiCall(PostServerLoginRequest postServerLoginRequest){
        return authApi.postLoginApiCall(postServerLoginRequest);
    }

    @Override
    public Single<PostRegisterResponse> postRegisterCall(PostServerRegisterRequest postServerRegisterRequest){
        return authApi.postRegisterCall(postServerRegisterRequest);
    }

    @Override
    public Single<GetForgotPasswordResponse> getForgotPassword(GetForgotPasswordRequest getForgotPasswordRequest){
        return authApi.getForgotPassword(getForgotPasswordRequest);
    }

    @Override
    public Single<GetForgotPasswordTokenResponse> getForgotPasswordTokenValidCall(GetForgotPasswordTokenRequest getForgotPasswordTokenRequest){
        return authApi.getForgotPasswordTokenValidCall(getForgotPasswordTokenRequest);
    }

}
