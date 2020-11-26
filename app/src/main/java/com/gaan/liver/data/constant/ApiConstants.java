package com.gaan.liver.data.constant;

public class ApiConstants {

    private static final String VERSION = "/apiv1" ;

    //Api Paths
    public static final String BASE_URL = "http://api.example.com" + VERSION;
    public static final String API_URL = "http://api.extended.example.com";
    public static final String FACEBOOK_API = "${FACEBOOK_IP}";
    public static final String GOOGLE_API = "${GOOGLE_IP}";

    //Api Keys
    public static final String BASE_KEY = "$KEY";
    public static final String API_KEY = "$KEY";
    public static final String FACEBOOK_KEY = "$KEY";
    public static final String GOOGLE_KEY = "$KEY";

    //Auth Router
    public static final String AUTH_SERVICE_POST_LOGIN_URL = BASE_URL + "/auth/login";
    public static final String AUTH_SERVICE_POST_REGISTER_URL = BASE_URL + "/auth/register";
    public static final String AUTH_SERVICE_POST_FORGOT_PASSWORD_URL = BASE_URL + "/auth/forgotPassword";
    public static final String AUTH_SERVICE_POST_FORGOT_PASSWORD_TOKEN_URL = BASE_URL + "/auth/forgotPasswordToken";

    //User Router
    public static final String USER_SERVICE_GET_USER_BY_LOC_URL = BASE_URL + "/users";
    public static final String USER_SERVICE_GET_USER_BY_ID_URL = BASE_URL + "/users/{userId}";
    public static final String USER_SERVICE_PUT_USER_BY_ID_URL = BASE_URL + "/users";
    public static final String USER_SERVICE_DELETE_USER_BY_ID_URL = BASE_URL + "/users";

    //Event Router
    public static final String EVENT_SERVICE_GET_EVENT_BY_ID_URL = "/events/{eventId}";
    public static final String EVENT_SERVICE_GET_EVENT_BY_LOC_URL = "/events";
    public static final String EVENT_SERVICE_POST_EVENT_URL = "/events";
    public static final String EVENT_SERVICE_DELETE_EVENT_BY_ID_URL = "/events";
    public static final String EVENT_SERVICE_PUT_EVENT_BY_ID_URL = "/events/{eventId}";

    //Retrofit Api Config
    public static final long CONNECT_TIMEOUT = 30000;
    public static final long READ_TIMEOUT = 30000;
    public static final long WRITE_TIMEOUT = 30000;

    private ApiConstants(){};
}
