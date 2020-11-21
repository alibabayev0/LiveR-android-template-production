package com.gaan.liver.ui.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.library.baseAdapters.BR;

import com.gaan.liver.R;
import com.gaan.liver.ui.base.BaseActivity;
import com.gaan.liver.databinding.ActivitySettingsBinding;
import com.gaan.liver.di.component.ActivityComponent;

public class SettingsActivity extends BaseActivity<ActivitySettingsBinding,SettingsViewModel> implements ISettingsNavigator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_settings;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, SettingsActivity.class);
    }
}