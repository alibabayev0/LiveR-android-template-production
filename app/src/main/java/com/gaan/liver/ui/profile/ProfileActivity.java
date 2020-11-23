package com.gaan.liver.ui.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.gaan.liver.R;
import com.gaan.liver.ui.base.BaseActivity;

public class ProfileActivity extends BaseActivity<ProfileViewModel> implements IProfileNavigator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_profile;
    }

    @Override
    public Class<ProfileViewModel> getViewModelClass() {
        return ProfileViewModel.class;
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, ProfileActivity.class);
    }

    @Override
    public void openSettingsActivity() {
        Intent intent = ProfileActivity.newIntent(this);
        startActivity(intent);
    }
}