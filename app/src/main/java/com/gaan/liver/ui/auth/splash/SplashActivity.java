package com.gaan.liver.ui.auth.splash;

import android.content.Intent;
import android.os.Bundle;

import com.gaan.liver.BR;
import com.gaan.liver.R;
import com.gaan.liver.ui.base.BaseActivity;
import com.gaan.liver.databinding.ActivitySplashBinding;
import com.gaan.liver.di.component.ActivityComponent;
import com.gaan.liver.ui.ar.ArActivity;

public class SplashActivity extends BaseActivity<ActivitySplashBinding,SplashViewModel> implements SplashNavigator {
    SplashViewModel splashViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
        mViewModel.startCheckStatusUser();
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }


    @Override
    public void openLoginActivity() {
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

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }
}