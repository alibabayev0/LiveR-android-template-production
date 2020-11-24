package com.gaan.liver.di.builder;

import com.gaan.liver.ui.ar.ArActivity;
import com.gaan.liver.ui.auth.forgotpassword.ForgotPasswordActivity;
import com.gaan.liver.ui.auth.login.LoginActivity;
import com.gaan.liver.ui.auth.register.RegisterActivity;
import com.gaan.liver.ui.auth.splash.SplashActivity;
import com.gaan.liver.ui.discover.DiscoverActivity;
import com.gaan.liver.ui.messenger.MessengerActivity;
import com.gaan.liver.ui.profile.ProfileActivity;
import com.gaan.liver.ui.settings.SettingsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract SplashActivity contributeSplashActivityy();

    @ContributesAndroidInjector
    abstract LoginActivity contributeLoginActivity();

    @ContributesAndroidInjector
    abstract RegisterActivity contributeRegisterActivity();

    @ContributesAndroidInjector
    abstract ForgotPasswordActivity contributeForgotPasswordActivity();

    @ContributesAndroidInjector
    abstract DiscoverActivity contributeDiscoverActivity();

    @ContributesAndroidInjector
    abstract MessengerActivity contributeMessengerActivity();

    @ContributesAndroidInjector
    abstract ProfileActivity contributeProfileActivity();

    @ContributesAndroidInjector
    abstract SettingsActivity contributeSettingsActivity();

    @ContributesAndroidInjector
    abstract ArActivity contributeArActivity();
}
