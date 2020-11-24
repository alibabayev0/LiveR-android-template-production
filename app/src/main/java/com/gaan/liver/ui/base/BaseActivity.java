 package com.gaan.liver.ui.base;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.LayoutRes;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.gaan.liver.ViewModelFactory;
import com.gaan.liver.ui.auth.login.LoginActivity;
import com.gaan.liver.ui.auth.splash.SplashViewModel;
import com.gaan.liver.util.network.NetworkUtils;
import com.gaan.liver.util.ui.ViewUIUtil;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public abstract class BaseActivity<V extends ViewModel> extends DaggerAppCompatActivity {

    protected final String TAG = this.getClass().getName();

    private ProgressDialog mProgressDialog;


    @Inject
    ViewModelFactory viewModelFactory;
    protected V mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this, viewModelFactory).get(getViewModelClass());
    }


    public abstract
    @LayoutRes
    int getLayoutId();

    public abstract Class<V> getViewModelClass();

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

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