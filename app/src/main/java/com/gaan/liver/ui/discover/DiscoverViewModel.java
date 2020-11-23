package com.gaan.liver.ui.discover;

import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.rx.SchedulerProvider;

import javax.inject.Inject;

public class DiscoverViewModel extends BaseViewModel<IDiscoverNavigator> {
    @Inject
    public DiscoverViewModel(IUserDataManager iUserDataManager, SchedulerProvider schedulerProvider) {
        super(iUserDataManager, schedulerProvider);
    }
}
