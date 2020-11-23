package com.gaan.liver.ui.messenger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.gaan.liver.R;
import com.gaan.liver.ui.ar.ArActivity;
import com.gaan.liver.ui.base.BaseActivity;
import com.gaan.liver.ui.discover.DiscoverActivity;

public class MessengerActivity extends BaseActivity<MessengerViewModel> implements IMessengerNavigator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_messenger;
    }

    @Override
    public Class<MessengerViewModel> getViewModelClass() {
        return MessengerViewModel.class;
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