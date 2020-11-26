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

import io.reactivex.Single;

public interface IAuthRepository  {
    Single<PostLoginResponse> postFacebookApiCall(PostFacebookLoginRequest postFacebookLoginRequest);

    Single<PostLoginResponse> postGoogleApiCall(PostGoogleLoginRequest postGoogleLoginRequest);

    Single<PostLoginResponse> postLoginApiCall(PostServerLoginRequest postServerLoginRequest);

    Single<PostRegisterResponse> postRegisterCall(PostServerRegisterRequest postServerRegisterRequest);

    Single<GetForgotPasswordResponse> getForgotPassword(GetForgotPasswordRequest getForgotPasswordRequest);

    Single<GetForgotPasswordTokenResponse> getForgotPasswordTokenValidCall(GetForgotPasswordTokenRequest getForgotPasswordTokenRequest);
}
