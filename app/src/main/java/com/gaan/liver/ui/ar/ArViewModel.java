package com.gaan.liver.ui.ar;

import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.rx.SchedulerProvider;

public class ArViewModel extends BaseViewModel<ArNavigator> {


    public ArViewModel(IUserDataManager iUserDataManager, SchedulerProvider schedulerProvider) {
        super(iUserDataManager, schedulerProvider);
    }
}
