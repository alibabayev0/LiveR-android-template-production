package com.gaan.liver.ui.auth.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.gaan.liver.R;
import com.gaan.liver.ui.ar.ArActivity;
import com.gaan.liver.ui.base.BaseActivity;
import com.gaan.liver.util.logger.Logger;

public class RegisterActivity extends BaseActivity<RegisterViewModel> implements IRegisterNavigator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public Class<RegisterViewModel> getViewModelClass() {
        return RegisterViewModel.class;
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, RegisterActivity.class);
    }

    @Override
    public void openArActivity() {
        Intent intent = ArActivity.newIntent(this);
        startActivity(intent);
    }

    @Override
    public void handleError(Throwable throwable) {
        Logger.d("TAG",throwable.getMessage());
    }
}