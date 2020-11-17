package com.gaan.liver.ui.ar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.gaan.liver.BR;
import com.gaan.liver.R;
import com.gaan.liver.ui.base.BaseActivity;
import com.gaan.liver.databinding.ActivityArBinding;
import com.gaan.liver.di.component.ActivityComponent;

public class ArActivity extends BaseActivity<ActivityArBinding,ArViewModel> {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar);
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

}