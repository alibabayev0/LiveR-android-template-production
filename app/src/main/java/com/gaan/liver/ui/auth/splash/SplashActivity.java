package com.gaan.liver.ui.auth.splash;

import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.gaan.liver.R;
import com.gaan.liver.ViewModelFactory;
import com.gaan.liver.ui.auth.login.LoginActivity;
import com.gaan.liver.ui.base.BaseActivity;
import com.gaan.liver.ui.ar.ArActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity<SplashViewModel> implements SplashNavigator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(SplashActivity.this);
        mViewModel.startCheckStatusUser();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public Class<SplashViewModel> getViewModelClass() {
        return SplashViewModel.class;
    }


    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openLoginLikeActivity() {
        Intent intent = ArActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openArActivity() {
        Intent intent = ArActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

}