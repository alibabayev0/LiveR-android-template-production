package com.gaan.liver.ui.auth.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.databinding.library.baseAdapters.BR;

import com.gaan.liver.R;
import com.gaan.liver.ui.ar.ArActivity;
import com.gaan.liver.ui.base.BaseActivity;
import com.gaan.liver.databinding.ActivityLoginBinding;
import com.gaan.liver.di.component.ActivityComponent;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements ILoginNavigator {

    @Inject
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    public void openArActivity() {
        Intent intent = ArActivity.newIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void handleError(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
}