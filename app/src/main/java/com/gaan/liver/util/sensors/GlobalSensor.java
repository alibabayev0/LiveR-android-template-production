package com.gaan.liver.util.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.gaan.liver.data.model.pojo.SensorXY;
import com.gaan.liver.util.MathUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
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
    // the direction of the back camera, only valid if the device is tilted up by
    // at least 25 degrees.
    private float mFacing = Float.NaN;

    private PublishSubject<SensorXY> sensorXYPublishSubject;

    SensorXY sensorXY;

    public GlobalSensor(){
        sensorXYPublishSubject = PublishSubject.create();
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
                    mFacing = SensorUtil.findFacing(SensorUtil.average(mRotHist));
                }
                verticalDegree = MathUtil.toDegree(inclination);
                mFacing = MathUtil.normalizeDegree(MathUtil.toDegree(mFacing));

                sensorXY = new SensorXY(mFacing,verticalDegree);
                sensorXYPublishSubject.onNext(sensorXY);
            }
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

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
