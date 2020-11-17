package com.gaan.liver.ui.settings;

import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.rx.SchedulerProvider;

public class SettingsViewModel extends BaseViewModel<ISettingsNavigator> {
    public SettingsViewModel(IUserDataManager iUserDataManager, SchedulerProvider schedulerProvider) {
        super(iUserDataManager, schedulerProvider);
    }
}
