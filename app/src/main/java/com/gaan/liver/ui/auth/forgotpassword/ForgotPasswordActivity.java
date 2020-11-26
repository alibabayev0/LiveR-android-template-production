package com.gaan.liver.ui.auth.forgotpassword;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.gaan.liver.R;
import com.gaan.liver.ui.base.BaseActivity;

public class ForgotPasswordActivity extends BaseActivity<ForgotPasswordViewModel> implements IForgotPasswordNavigator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_forgot_password;
    }

    @Override
    public Class<ForgotPasswordViewModel> getViewModelClass() {
        return ForgotPasswordViewModel.class;
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, ForgotPasswordActivity.class);
    }

    @Override
    public void showViewOnResponse() {

    }

    @Override
    public void userNotFoundError(Throwable throwable) {

    }

    @Override
    public void passwordSuccefullyChangedResponse() {

    }

    @Override
    public void passwordChangingError(Throwable throwable) {

    }
}