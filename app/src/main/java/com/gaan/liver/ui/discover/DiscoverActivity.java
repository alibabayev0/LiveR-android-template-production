package com.gaan.liver.ui.discover;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.library.baseAdapters.BR;

import com.gaan.liver.R;
import com.gaan.liver.ui.ar.ArActivity;
import com.gaan.liver.ui.base.BaseActivity;
import com.gaan.liver.databinding.ActivityDiscoverBinding;
import com.gaan.liver.di.component.ActivityComponent;
import com.gaan.liver.ui.messenger.MessengerActivity;
import com.gaan.liver.ui.profile.ProfileActivity;

public class DiscoverActivity extends BaseActivity implements IDiscoverNavigator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_discover;
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, DiscoverActivity.class);
    }

    @Override
    public void openArActivity() {
        Intent intent = ArActivity.newIntent(this);
        startActivity(intent);
    }

    @Override
    public void openMessengerActivity() {
        Intent intent = MessengerActivity.newIntent(this);
        startActivity(intent);
    }

    @Override
    public void openProfileActivity() {
        Intent intent = ProfileActivity.newIntent(this);
        startActivity(intent);
    }
}