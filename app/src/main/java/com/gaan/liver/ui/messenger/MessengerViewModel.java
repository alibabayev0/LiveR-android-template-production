package com.gaan.liver.ui.messenger;

import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.rx.SchedulerProvider;

public class MessengerViewModel extends BaseViewModel<IMessengerNavigator> {
    public MessengerViewModel(IUserDataManager iUserDataManager, SchedulerProvider schedulerProvider) {
        super(iUserDataManager, schedulerProvider);
    }
}
