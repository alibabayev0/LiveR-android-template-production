package com.gaan.liver.ui.ar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;

import com.gaan.liver.R;
import com.gaan.liver.data.model.api.response.GetEventResponse;
import com.gaan.liver.data.model.pojo.SensorXY;
import com.gaan.liver.databinding.ActivityArBinding;
import com.gaan.liver.ui.base.BaseActivity;
import com.gaan.liver.ui.discover.DiscoverActivity;
import com.gaan.liver.ui.messenger.MessengerActivity;
import com.gaan.liver.util.MathUtil;
import com.gaan.liver.util.ui.ShowCamera;

import java.util.List;

import static android.view.View.VISIBLE;
import static com.gaan.liver.data.constant.SensorConstants.X_TOTAL_RANGE;
import static com.gaan.liver.data.constant.SensorConstants.Y_TOTAL_RANGE;

public class ArActivity extends BaseActivity<ArViewModel> implements ArNavigator {

    ActivityArBinding activityArBinding;

    Camera mCamera;
    ShowCamera mShowCamera;

    FrameLayout mFrameLayout;

    int mDeviceSizeHeight, mDeviceSizeWidth;   //3020 1440
    List<GetEventResponse> mListGetEventResponse;

    private final int ITEM_NORMAL_IMAGE_HEIGHT = 230;
    private final int ITEM_NORMAL_IMAGE_WIDTH = 230;
    private final int ITEM_ZOOMED_IMAGE_HEIGHT = 260;
    private final int ITEM_ZOOMED_IMAGE_WIDTH = 260;

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
        mFrameLayout = activityArBinding.camera;
        mCamera = Camera.open();
        mShowCamera = new ShowCamera(this, mCamera);
        mFrameLayout.addView(mShowCamera);
    }

    private void finalizeCamera(){
        mCamera.stopPreview();
        mCamera.release();
        mFrameLayout.removeAllViews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initSizes();
        mViewModel.startSearching();
    }

    private void initSizes() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        mDeviceSizeWidth = size.x;
        mDeviceSizeHeight = size.y;
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

    @Override
    public void showItems(List<GetEventResponse> getEventResponseList) {
        mListGetEventResponse = getEventResponseList;
        activityArBinding.itemFrameLayouts.removeAllViews();
        for (GetEventResponse item :
                getEventResponseList) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(ITEM_NORMAL_IMAGE_WIDTH, ITEM_NORMAL_IMAGE_HEIGHT));
            imageView.setTag(item.get_id());
            imageView.setVisibility(View.INVISIBLE);
            activityArBinding.itemFrameLayouts.addView(imageView);
        }
    }

    @Override
    public void setRangeOfView(SensorXY mSensorXY) {
        for (GetEventResponse item:
             mListGetEventResponse) {
            ImageView imageView  = activityArBinding.itemFrameLayouts.findViewWithTag(item.get_id());
            imageView.setVisibility(View.GONE);
            boolean matchPointForZooming = MathUtil.findOnePointOverlapRectangle(item.getDegreeX(), item.getDegreeY(), ITEM_NORMAL_IMAGE_WIDTH, ITEM_NORMAL_IMAGE_HEIGHT, mDeviceSizeWidth / 2.0d, mDeviceSizeHeight / 2.0d);
            boolean matchPointForInsideView = MathUtil.findPointInsideView(mSensorXY,item.getDegreeX(), item.getDegreeY());
            if (matchPointForInsideView && matchPointForZooming && imageView.getHeight() == ITEM_ZOOMED_IMAGE_HEIGHT) {
                imageView.getLayoutParams().width = ITEM_ZOOMED_IMAGE_WIDTH;
                imageView.getLayoutParams().height = ITEM_ZOOMED_IMAGE_HEIGHT;
                imageView.setTranslationX(getItemXOnView(mSensorXY) - ((ITEM_ZOOMED_IMAGE_WIDTH - ITEM_NORMAL_IMAGE_WIDTH) / 2f));
                imageView.setTranslationY(getItemYOnView(mSensorXY) - ((ITEM_ZOOMED_IMAGE_HEIGHT - ITEM_NORMAL_IMAGE_HEIGHT) / 2f));
            }
            else if(matchPointForInsideView){
                imageView.getLayoutParams().width = ITEM_NORMAL_IMAGE_WIDTH;
                imageView.getLayoutParams().height = ITEM_NORMAL_IMAGE_HEIGHT;
                imageView.setTranslationX(getItemXOnView(mSensorXY));
                imageView.setTranslationY(getItemYOnView(mSensorXY));
                imageView.requestLayout();
            }
            imageView.setVisibility(VISIBLE);
        }
    }

    public float getItemXOnView(SensorXY sensorXY){
        return ((mDeviceSizeWidth / X_TOTAL_RANGE) * (sensorXY.getHorizontalDegree() - sensorXY.getMinHorizontalDegree()));
    }

    public float getItemYOnView(SensorXY sensorXY){
        return ((mDeviceSizeHeight / Y_TOTAL_RANGE) * (Y_TOTAL_RANGE - (sensorXY.getVerticalDegree() - sensorXY.getMinVerticallDegree())));
    }

    @Override
    public void handlerShowItemsError(Throwable throwable) {

    }
}