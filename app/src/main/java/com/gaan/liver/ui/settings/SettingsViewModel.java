package com.gaan.liver.ui.settings;

import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.rx.SchedulerProvider;

import javax.inject.Inject;

public class SettingsViewModel extends BaseViewModel<ISettingsNavigator> {
    @Inject
    public SettingsViewModel(IUserDataManager iUserDataManager, SchedulerProvider schedulerProvider) {
        super(iUserDataManager, schedulerProvider);
    }
}
