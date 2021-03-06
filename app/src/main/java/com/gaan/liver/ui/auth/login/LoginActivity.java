package com.gaan.liver.ui.auth.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.gaan.liver.R;
import com.gaan.liver.ui.ar.ArActivity;
import com.gaan.liver.ui.auth.forgotpassword.ForgotPasswordActivity;
import com.gaan.liver.ui.base.BaseActivity;

public class LoginActivity extends BaseActivity<LoginViewModel> implements ILoginNavigator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
        mViewModel.checkUserExist();
//        openArActivity();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public Class<LoginViewModel> getViewModelClass() {
        return LoginViewModel.class;
    }


    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    public void openArActivity() {
        Intent intent = ArActivity.newIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openForgotPasswordActivity() {
        Intent intent = ForgotPasswordActivity.newIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void changeViewToUserExist(String username, String profilePicPath) {

    }

    @Override
    public void handleError(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
}