package com.gaan.liver.util.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import androidx.databinding.ObservableFloat;
import androidx.lifecycle.LiveData;

import com.gaan.liver.data.model.SensorXY;
import com.gaan.liver.ui.ar.SensorValueChangedListener;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.subjects.PublishSubject;

public class GlobalSensor implements SensorEventListener {
    private List<float[]> mRotHist = new ArrayList<float[]>();
    private int mRotHistIndex;
    // Change the value so that the azimuth is stable and fit your requirement
    private int mHistoryMaxLength = 40;
    float[] mGravity;
    float[] mMagnetic;
    float[] mRotationMatrix = new float[9];
    float[] mAaccelerometer;
    float verticalDegree;
    float z;
    // the direction of the back camera, only valid if the device is tilted up by
    // at least 25 degrees.
    private float mFacing = Float.NaN;

    public PublishSubject<SensorXY> sensorXYPublishSubject = PublishSubject.create();

    SensorXY sensorXY;

    public GlobalSensor(){
    }

    public Observable<SensorXY> getSensorXYPublishSubject() {
        return sensorXYPublishSubject;
    }

    public static final float THIRTY_DEGREE_IN_RADIAN = 0.261799f; // 15
    public static final float ONE_FIFTY_FIVE_DEGREE_IN_RADIAN = 3.05433f; //175
    @Override
    public void onSensorChanged(SensorEvent event)
    {
        if (event.sensor.getType() == Sensor.TYPE_GRAVITY)
        {
            mGravity = event.values.clone();
        }
        else if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            mAaccelerometer = event.values.clone();
        }
        else
        {
            mMagnetic = event.values.clone();
        }
        if (mGravity != null && mMagnetic != null && mAaccelerometer != null)
        {
            if (SensorManager.getRotationMatrix(mRotationMatrix, null, mGravity, mMagnetic))
            {
//                Log.d(TAG, "Pitch : " + (orientationa[1] * 57.2957795f));
//                Log.d(TAG, "roll : " + (orientationa[2] * 57.2957795f));

                // if less than 25 or more than 155 degrees the device is considered lying flat
                float inclination = (float) Math.acos(mRotationMatrix[8]);
                if ((inclination < THIRTY_DEGREE_IN_RADIAN
                        || inclination > ONE_FIFTY_FIVE_DEGREE_IN_RADIAN) )
//                || Math.abs(mAaccelerometer[0]) > 4
                {
                    clearRotHist();
                    mFacing = Float.NaN;
                    return;
                }
                else
                {
                    setRotHist();
                    mFacing = findFacing();
                }
                verticalDegree = radianToDegree(inclination);
                mFacing = normalizeDegree(radianToDegree(mFacing));

                sensorXY = new SensorXY(mFacing,verticalDegree);
                sensorXYPublishSubject.onNext(sensorXY);
            }
        }
    }

    private float radianToDegree(float radian){
        return (float) (radian * 180 / Math.PI);
    }

    private float normalizeDegree(float value){
        if(value >= 0.0f && value <= 180.0f){
            return value;
        }else{
            return 180 + (180 + value);
        }
    }

    private void clearRotHist()
    {
        mRotHist.clear();
        mRotHistIndex = 0;
    }

    private void setRotHist()
    {
        float[] hist = mRotationMatrix.clone();
        if (mRotHist.size() == mHistoryMaxLength)
        {
            mRotHist.remove(mRotHistIndex);
        }
        mRotHist.add(mRotHistIndex++, hist);
        mRotHistIndex %= mHistoryMaxLength;
    }

    private float findFacing()
    {
        float[] averageRotHist = average(mRotHist);
        return (float) Math.atan2(-averageRotHist[2], -averageRotHist[5]);
    }

    private float findAzimuth(){
        float[] averageRotHist = average(mRotHist);
        return (float) Math.atan2((averageRotHist[1] - averageRotHist[3]), (averageRotHist[0] + averageRotHist[4]));
    }


    public float[] average(List<float[]> values)
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
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
