package com.gaan.liver.ui.ar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.gaan.liver.BR;
import com.gaan.liver.R;
import com.gaan.liver.ui.auth.splash.SplashActivity;
import com.gaan.liver.ui.base.BaseActivity;
import com.gaan.liver.databinding.ActivityArBinding;
import com.gaan.liver.di.component.ActivityComponent;
import com.gaan.liver.ui.discover.DiscoverActivity;
import com.gaan.liver.ui.messenger.MessengerActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import javax.inject.Inject;

public class ArActivity extends BaseActivity<ActivityArBinding,ArViewModel> implements ArNavigator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(ArActivity.this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_ar;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, ArActivity.class);
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void openDiscover() {
        Intent intent = DiscoverActivity.newIntent(this);
        startActivity(intent);
    }

    @Override
    public void openMessenger() {
        Intent intent = MessengerActivity.newIntent(this);
        startActivity(intent);
    }
}