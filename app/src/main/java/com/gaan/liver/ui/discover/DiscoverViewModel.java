package com.gaan.liver.ui.discover;

import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.rx.SchedulerProvider;

public class DiscoverViewModel extends BaseViewModel<IDiscoverNavigator> {
    public DiscoverViewModel(IUserDataManager iUserDataManager, SchedulerProvider schedulerProvider) {
        super(iUserDataManager, schedulerProvider);
    }
}
