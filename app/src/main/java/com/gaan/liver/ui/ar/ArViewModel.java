package com.gaan.liver.ui.ar;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.Observer;

import com.gaan.liver.data.model.LoggedStatus;
import com.gaan.liver.data.model.SensorXY;
import com.gaan.liver.data.model.api.request.ServerLoginRequest;
import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.rx.SchedulerProvider;
import com.gaan.liver.util.sensors.GlobalSensor;

import org.jetbrains.annotations.NotNull;

import io.reactivex.Single;
import io.reactivex.internal.operators.single.SingleJust;

public class ArViewModel extends BaseViewModel<ArNavigator> implements SensorValueChangedListener{

    public ArViewModel(IUserDataManager iUserDataManager, SchedulerProvider schedulerProvider) {
        super(iUserDataManager, schedulerProvider);

    }

    public void initSensor(){

    }

    @Override
    public void onHorizontalAndVerticalDegreeChanged() {

    }
}
