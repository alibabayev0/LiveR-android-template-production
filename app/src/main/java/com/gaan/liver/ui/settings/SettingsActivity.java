package com.gaan.liver.ui.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.gaan.liver.R;
import com.gaan.liver.ui.base.BaseActivity;

public class SettingsActivity extends BaseActivity<SettingsViewModel> implements ISettingsNavigator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_settings;
    }

    @Override
    public Class<SettingsViewModel> getViewModelClass() {
        return SettingsViewModel.class;
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, SettingsActivity.class);
    }
}