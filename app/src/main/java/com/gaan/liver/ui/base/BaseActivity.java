 package com.gaan.liver.ui.base;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.gaan.liver.MvvmApp;
import com.gaan.liver.di.component.ActivityComponent;
import com.gaan.liver.di.component.AppComponent;
import com.gaan.liver.di.component.DaggerActivityComponent;
import com.gaan.liver.di.module.ActivityModule;
import com.gaan.liver.ui.auth.login.LoginActivity;
import com.gaan.liver.util.network.NetworkUtils;
import com.gaan.liver.util.ui.ViewUIUtil;

import javax.inject.Inject;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public abstract class BaseActivity extends AppCompatActivity {


    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        performDependencyInjection(getBuildComponent());
        super.onCreate(savedInstanceState);
    }


    public abstract
    @LayoutRes
    int getLayoutId();


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }


    /**
     * getBuildComponent building appComponent and activitymodule
     * @return ActivityComponent
     */
    private ActivityComponent getBuildComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(((MvvmApp) getApplication()).appComponent)
                .activityModule(new ActivityModule(this))
                .build();
    }

    public abstract void performDependencyInjection(ActivityComponent buildComponent);

    /**
     *
     * Hiding Keyboard manually
     */
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    /**
     *
     * @param clz
     * @param bundle
     * Function for starting clz activity with bundle
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * If server respons that user token is expired automatically returning to loginactivity
     */
    public void openActivityOnTokenExpire() {
        startActivity(LoginActivity.newIntent(this));
        finish();
    }


    /**
     * Network Status checker by Utils
     * @return
     */
    public boolean hasNetwork() {
        return NetworkUtils.hasNetwork(getApplicationContext());
    }


    public void showLoading() {
        hideLoading();
        mProgressDialog = ViewUIUtil.showLoadingDialog(this);
    }

    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

}