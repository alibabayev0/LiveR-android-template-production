package com.gaan.liver.util;

public class MathUtil {
    public static float toRadians(float degree){
        return (float) (degree * Math.PI / 180);
    }

    public static float toDegree(float radian){
        return (float) (radian * 180 / Math.PI );
    }

    public static float normalizeDegree(float degree){
        if(degree >= 0.0f && degree <= 180.0f){
            return degree;
        }else{
            return 180 + (180 + degree);
        }
    }

}
