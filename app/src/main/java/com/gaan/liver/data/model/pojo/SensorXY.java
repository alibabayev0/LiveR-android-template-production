package com.gaan.liver.data.model.pojo;

public class SensorXY {
    private float horizontalDegree;
    private float verticalDegree;

    public SensorXY(float horizontalDegree, float verticalDegree) {
        this.horizontalDegree = horizontalDegree;
        this.verticalDegree = verticalDegree;
    }

    public float getHorizontalDegree() {
        return horizontalDegree;
    }

    public void setHorizontalDegree(float horizontalDegree) {
        this.horizontalDegree = horizontalDegree;
    }

    public float getVerticalDegree() {
        return verticalDegree;
    }

    public void setVerticalDegree(float verticalDegree) {
        this.verticalDegree = verticalDegree;
    }
}
