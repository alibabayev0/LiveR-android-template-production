package com.gaan.liver.ui.auth.forgotpassword;

import com.gaan.liver.ui.base.BaseViewModel;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.rx.SchedulerProvider;

public class ForgotPasswordViewModel extends BaseViewModel<IForgotPasswordNavigator> {

    public ForgotPasswordViewModel(IUserDataManager iUserDataManager, SchedulerProvider schedulerProvider) {
        super(iUserDataManager, schedulerProvider);
    }
}
