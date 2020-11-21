package com.gaan.liver.ui.messenger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.library.baseAdapters.BR;

import com.gaan.liver.R;
import com.gaan.liver.ui.ar.ArActivity;
import com.gaan.liver.ui.base.BaseActivity;
import com.gaan.liver.databinding.ActivityMessengerBinding;
import com.gaan.liver.di.component.ActivityComponent;
import com.gaan.liver.ui.discover.DiscoverActivity;

public class MessengerActivity extends BaseActivity<ActivityMessengerBinding,MessengerViewModel> implements IMessengerNavigator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_messenger;
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
        return new Intent(context, MessengerActivity.class);
    }

    @Override
    public void openArActivity() {
        Intent intent = ArActivity.newIntent(this);
        startActivity(intent);
    }

    @Override
    public void openDiscoverActivity() {
        Intent intent = DiscoverActivity.newIntent(this);
        startActivity(intent);
    }
}