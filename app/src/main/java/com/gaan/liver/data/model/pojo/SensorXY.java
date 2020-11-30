package com.gaan.liver.data.model.pojo;

import static com.gaan.liver.data.constant.SensorConstants.X_MAX_RANGE;
import static com.gaan.liver.data.constant.SensorConstants.X_MIN_RANGE;
import static com.gaan.liver.data.constant.SensorConstants.Y_MAX_RANGE;
import static com.gaan.liver.data.constant.SensorConstants.Y_MIN_RANGE;

public class SensorXY {
    private float horizontalDegree;
    private float verticalDegree;

    public SensorXY(float horizontalDegree, float verticalDegree) {
        this.horizontalDegree = Float.isNaN(horizontalDegree) ? 0.0f : horizontalDegree;
        this.verticalDegree = Float.isNaN(verticalDegree) ? 0.0f : verticalDegree;
    }

    public float getHorizontalDegree() {
        return horizontalDegree;
    }

    public void setHorizontalDegree(float horizontalDegree) {
        this.horizontalDegree = Float.isNaN(horizontalDegree) ? 0.0f : horizontalDegree;
    }

    public float getVerticalDegree() {
        return verticalDegree;
    }

    public void setVerticalDegree(float verticalDegree) {
        this.verticalDegree = Float.isNaN(verticalDegree) ? 0.0f : verticalDegree;
    }

    public float getMaxHorizontalDegree(){
        return horizontalDegree + X_MAX_RANGE;
    }

    public float getMinHorizontalDegree(){
        return horizontalDegree + X_MIN_RANGE;
    }

    public float getMaxVerticallDegree(){
        return horizontalDegree + Y_MAX_RANGE;
    }

    public float getMinVerticallDegree(){
        return horizontalDegree + Y_MIN_RANGE;
    }
}
