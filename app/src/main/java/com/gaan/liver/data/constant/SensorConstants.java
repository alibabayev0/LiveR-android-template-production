package com.gaan.liver.data.constant;

public class SensorConstants {
    //Location
    public final static long LOCATION_TRACKING_INTERVAL = 5000; // 5 sec
    public final static float LOCATION_TRACKING_DISTANCE = 1.5f; // 1.5meter


    //Range of Horizontal
    public final static float X_MIN_RANGE = -30;
    public final static float X_MAX_RANGE = 30;
    public final static float X_TOTAL_RANGE = Math.abs(X_MAX_RANGE) + Math.abs(X_MIN_RANGE);
    //Range of Vertical
    public final static float Y_MIN_RANGE = -30;
    public final static float Y_MAX_RANGE = 30;
    public final static float Y_TOTAL_RANGE = Math.abs(Y_MAX_RANGE) + Math.abs(Y_MIN_RANGE);


    //Close item sizes

}
