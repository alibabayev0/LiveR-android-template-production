package com.gaan.liver.util;

import com.gaan.liver.data.model.pojo.SensorXY;

public class MathUtil {
    public static float toRadians(float degree){
        return (float) (degree * Math.PI / 180);
    }

    public static double toRadians(double degree){
        return (float) (degree * Math.PI / 180);
    }

    public static float toDegree(float radian){
        return (float) (radian * 180 / Math.PI );
    }

    public static double toDegree(double radian){
        return (double) (radian * 180 / Math.PI );
    }

    public static float normalizeDegree(float degree){
        if(degree >= 0.0f && degree <= 180.0f){
            return degree;
        }else{
            return 180 + (180 + degree);
        }
    }

    public static boolean findOnePointOverlapRectangle(double centerRectangleX, double centerRectangleY, double horizontalLengthToCenter,double verticalLengthToCenter, double pointX, double pointY)
    {
        double rectangleX1 = centerRectangleX - horizontalLengthToCenter;
        double rectangleX2 = centerRectangleX + horizontalLengthToCenter;
        double rectangleY1 = centerRectangleY - verticalLengthToCenter;
        double rectangleY2 = centerRectangleY + verticalLengthToCenter;

        return pointX >= rectangleX1 && pointX <= rectangleX2 &&
                rectangleY1 >= pointY && rectangleY1 <= pointY + rectangleY2;
    }

    public static boolean findPointInsideView(SensorXY mSensorXY,double degreeX,double degreeY){
        return mSensorXY.getMinHorizontalDegree() <= degreeX + 40 && degreeX - 20 <= mSensorXY.getMaxHorizontalDegree() && mSensorXY.getMinVerticallDegree() <= degreeY + 20 && degreeY <= mSensorXY.getMaxVerticallDegree();
    }
}
