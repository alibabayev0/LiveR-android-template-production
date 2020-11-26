package com.gaan.liver.data.remote;


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

import javax.inject.Singleton;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import static com.gaan.liver.data.constant.ApiConstants.AUTH_SERVICE_POST_FORGOT_PASSWORD_TOKEN_URL;
import static com.gaan.liver.data.constant.ApiConstants.AUTH_SERVICE_POST_FORGOT_PASSWORD_URL;
import static com.gaan.liver.data.constant.ApiConstants.AUTH_SERVICE_POST_LOGIN_URL;
import static com.gaan.liver.data.constant.ApiConstants.AUTH_SERVICE_POST_REGISTER_URL;

@Singleton
public interface AuthService {
    @POST(AUTH_SERVICE_POST_LOGIN_URL)
    Single<PostLoginResponse> postFacebookApiCall(@Body PostFacebookLoginRequest postFacebookLoginRequest);

    @POST(AUTH_SERVICE_POST_LOGIN_URL)
    Single<PostLoginResponse> postGoogleApiCall(@Body PostGoogleLoginRequest postGoogleLoginRequest);

    @POST(AUTH_SERVICE_POST_LOGIN_URL)
    Single<PostLoginResponse> postLoginApiCall(@Body PostServerLoginRequest postServerLoginRequest);

    @POST(AUTH_SERVICE_POST_REGISTER_URL)
    Single<PostRegisterResponse> postRegisterCall(@Body PostServerRegisterRequest postServerRegisterRequest);

    @POST(AUTH_SERVICE_POST_FORGOT_PASSWORD_URL)
    Single<GetForgotPasswordResponse> getForgotPassword(@Body GetForgotPasswordRequest getForgotPasswordRequest);

    @POST(AUTH_SERVICE_POST_FORGOT_PASSWORD_TOKEN_URL)
    Single<GetForgotPasswordTokenResponse> getForgotPasswordTokenValidCall(@Body GetForgotPasswordTokenRequest getForgotPasswordTokenRequest);
}
