package com.gaan.liver.ui.ar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import com.gaan.liver.R;
import com.gaan.liver.ViewModelFactory;
import com.gaan.liver.ui.base.BaseActivity;
import com.gaan.liver.ui.discover.DiscoverActivity;
import com.gaan.liver.ui.messenger.MessengerActivity;

import javax.inject.Inject;

public class ArActivity extends BaseActivity<ArViewModel> implements ArNavigator {

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
    public Class<ArViewModel> getViewModelClass() {
        return ArViewModel.class;
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, ArActivity.class);
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