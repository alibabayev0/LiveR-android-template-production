package com.gaan.liver.ui.ar;

import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.ViewModelProvider;

import com.gaan.liver.R;
import com.gaan.liver.ViewModelFactory;
import com.gaan.liver.databinding.ActivityArBinding;
import com.gaan.liver.ui.base.BaseActivity;
import com.gaan.liver.ui.discover.DiscoverActivity;
import com.gaan.liver.ui.messenger.MessengerActivity;
import com.gaan.liver.util.ui.ShowCamera;

import javax.inject.Inject;

public class ArActivity extends BaseActivity<ArViewModel> implements ArNavigator {

     ActivityArBinding activityArBinding;

    Camera camera;
    ShowCamera showCamera;

    FrameLayout frameLayout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_ar;
    }

    @Override
    public Class<ArViewModel> getViewModelClass() {
        return ArViewModel.class;
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, ArActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
        performDataBinding();
        initCamera();
    }

    private void performDataBinding() {
        activityArBinding = DataBindingUtil.setContentView(this, getLayoutId());
        activityArBinding.setVariable(BR.viewModel, mViewModel);
        activityArBinding.executePendingBindings();
    }

    private void initCamera() {
        frameLayout = activityArBinding.camera;
        camera = Camera.open();
        showCamera = new ShowCamera(this,camera);
        frameLayout.addView(showCamera);
    }

    private void finalizeCamera(){
        camera.stopPreview();
        camera.release();
        frameLayout.removeAllViews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.startSearching();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finalizeCamera();
        mViewModel.stopSearching();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initCamera();
        mViewModel.startSearching();
    }

    @Override
    public void openDiscover() {
        Intent intent = DiscoverActivity.newIntent(this);
        startActivity(intent);
    }

    @Override
    public void openMessenger() {
        Intent intent = MessengerActivity.newIntent(this);
        startActivity(intent);
    }
}