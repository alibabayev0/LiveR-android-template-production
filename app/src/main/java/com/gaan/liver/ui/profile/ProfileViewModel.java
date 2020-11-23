package com.gaan.liver.ui.profile;

import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.rx.SchedulerProvider;

import javax.inject.Inject;

public class ProfileViewModel extends BaseViewModel<IProfileNavigator> {
    @Inject
    public ProfileViewModel(IUserDataManager iUserDataManager, SchedulerProvider schedulerProvider) {
        super(iUserDataManager, schedulerProvider);
    }
}
