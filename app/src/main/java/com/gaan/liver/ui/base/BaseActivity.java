package com.gaan.liver.ui.base;


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

import com.gaan.liver.App;
import com.gaan.liver.di.component.ActivityComponent;
import com.gaan.liver.di.component.DaggerActivityComponent;
import com.gaan.liver.di.module.ActivityModule;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public abstract class BaseActivity<T extends ViewDataBinding, V extends ViewModel> extends AppCompatActivity {

    private T mViewDataBinding;

    protected V mViewModel;

//
//    protected Class<V> mViewModelClass;
//
//    public void BaseActivity(Class<V> mViewModelClass){
//        this.mViewModelClass = mViewModelClass;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDataBinding();
    }


    public abstract
    @LayoutRes
    int getLayoutId();

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
        public abstract int getBindingVariable();


    /**
     *
     * DataBinding setter
     */
    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private ActivityComponent getBuildComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(((App)getApplication()).appComponent)
                .activityModule(new ActivityModule(this))
                .build();
    }

    public abstract void performDependencyInjection(ActivityComponent buildComponent);

    /**
     *
     * Hiding Keyboard in every view
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

    public void openActivityOnTokenExpire() {
//        startActivity(LoginActivity.newIntent(this));
        finish();
    }


//    /**
//     * Network Status checker by Utils
//     * @return
//     */
//    public boolean isNetworkConnected() {
//        return NetworkUtils.isNetworkConnected(getApplicationContext());
//    }


    private void performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.setLifecycleOwner(this);
        mViewDataBinding.executePendingBindings();
    }
}