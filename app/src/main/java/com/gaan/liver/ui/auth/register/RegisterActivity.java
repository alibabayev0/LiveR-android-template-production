package com.gaan.liver.ui.auth.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.library.baseAdapters.BR;

import com.gaan.liver.R;
import com.gaan.liver.ui.base.BaseActivity;
import com.gaan.liver.databinding.ActivityRegisterBinding;
import com.gaan.liver.di.component.ActivityComponent;

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding,RegisterViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
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
        return new Intent(context, RegisterActivity.class);
    }
}