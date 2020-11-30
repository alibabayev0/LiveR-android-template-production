package com.gaan.liver.ui.discover;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.gaan.liver.R;
import com.gaan.liver.data.model.api.response.GetEventResponse;
import com.gaan.liver.data.model.api.response.GetUserResponse;
import com.gaan.liver.databinding.ActivityArBinding;
import com.gaan.liver.databinding.ActivityDiscoverBinding;
import com.gaan.liver.ui.ar.ArActivity;
import com.gaan.liver.ui.base.BaseActivity;
import com.gaan.liver.ui.messenger.MessengerActivity;
import com.gaan.liver.ui.profile.ProfileActivity;

import java.util.List;

import javax.inject.Inject;

public class DiscoverActivity extends BaseActivity<DiscoverViewModel> implements IDiscoverNavigator{
    ActivityDiscoverBinding activityArBinding;

    @Inject
    DiscoverNearbyEventsAdapter discoverNearbyEventsAdapter;
    RecyclerView mDiscoverNearbyEventsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
        performDataBinding();
        initDiscoverNearbyEventsRecyclerView();
    }

    private void performDataBinding() {
        activityArBinding = DataBindingUtil.setContentView(this, getLayoutId());
        activityArBinding.setVariable(BR.viewModel, mViewModel);
        activityArBinding.executePendingBindings();
    }

    private void initDiscoverNearbyEventsRecyclerView() {
        mDiscoverNearbyEventsRecyclerView = activityArBinding.nearbyEventsRecyclerView;
        mDiscoverNearbyEventsRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
        mDiscoverNearbyEventsRecyclerView.setAdapter(discoverNearbyEventsAdapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_discover;
    }

    @Override
    public Class<DiscoverViewModel> getViewModelClass() {
        return DiscoverViewModel.class;
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, DiscoverActivity.class);
    }

    @Override
    public void openArActivity() {
        Intent intent = ArActivity.newIntent(this);
        startActivity(intent);
    }

    @Override
    public void openMessengerActivity() {
        Intent intent = MessengerActivity.newIntent(this);
        startActivity(intent);
    }

    @Override
    public void openProfileActivity() {
        Intent intent = ProfileActivity.newIntent(this);
        startActivity(intent);
    }

    @Override
    public void showNearbyPlaces() {
    }

    @Override
    public void showNearbyEvents(List<GetEventResponse> getEventResponseList) {

    }

    @Override
    public void showNearbyPeople(List<GetUserResponse> userResponses) {

    }

    @Override
    public void errorNearbyPlaces(Throwable throwable) {

    }

    @Override
    public void errorNearbyEvents(Throwable throwable) {

    }

    @Override
    public void errorNearbyPeople(Throwable throwable) {

    }
}