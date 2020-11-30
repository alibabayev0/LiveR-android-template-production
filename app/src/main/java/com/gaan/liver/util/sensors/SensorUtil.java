package com.gaan.liver.util.sensors;

import android.location.Location;

import com.gaan.liver.data.constant.SensorConstants;
import com.gaan.liver.util.MathUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SensorUtil {
//
//    private static ArrayList<Float> horizontalRange(float bearing) {
//        float maxBearX = bearing + SensorConstants.X_MAX_RANGE;
//        float minBearX = bearing + SensorConstants.X_MIN_RANGE;
//        return new ArrayList<>(Arrays.asList(minBearX,maxBearX));
//    }
//
//    private static ArrayList<Float> verticalRange(float inclination) {
//        float maxBearY = inclination + SensorConstants.Y_MAX_RANGE;
//        float minBearY = inclination + SensorConstants.Y_MIN_RANGE;
//        return new ArrayList<>(Arrays.asList(minBearY,maxBearY));
//    }



    public static double horizontalDegreeToItem(double startLat, double startLng, double destLat, double destLng){
        startLat = MathUtil.toRadians(startLat);
        startLng = MathUtil.toRadians(startLng);
        destLat = MathUtil.toRadians(destLat);
        destLng = MathUtil.toRadians(destLng);

        double y =  (Math.sin(destLng - startLng) * Math.cos(destLat));
        double x =  (Math.cos(startLat) * Math.sin(destLat) -
                        Math.sin(startLat) * Math.cos(destLat) * Math.cos(destLng - startLng));

        double degree = Math.atan2(x,y);
        degree = MathUtil.toDegree((double) degree);
        return (double) ((degree + 360) % 360);
    }


    public static double verticalDegreeToItem(double startLat,double startLon,double startEle, double destLat,double destLon,double destEle){
        Location start = new Location("start");
        start.setLatitude(startLat);
        start.setLongitude(startLon);

        Location dest = new Location("dest");
        dest.setLatitude(destLat);
        dest.setLongitude(destLon);

        double distance = start.distanceTo(dest);

        double height = destEle - startEle;
        double symbol = height != 0 ? (height / -height) : 0;
        double triangle = height != 0 ? height / distance : 0;
        return (double) (90 + (Math.tan(triangle) * symbol));
    }

    public static float[] average(List<float[]> values)
    {
        float[] result = new float[9];
        for (float[] value : values)
        {
            for (int i = 0; i < 9; i++)
            {
                result[i] += value[i];
            }
        }

        for (int i = 0; i < 9; i++)
        {
            result[i] = result[i] / values.size();
        }

        return result;
    }

    public static float findAzimuth(float[] averageRotHist){
        return (float) Math.atan2((averageRotHist[1] - averageRotHist[3]), (averageRotHist[0] + averageRotHist[4]));
    }

    public static float findFacing(float[] averageRotHist){
        return (float) Math.atan2(-averageRotHist[2], -averageRotHist[5]);
    }

}
