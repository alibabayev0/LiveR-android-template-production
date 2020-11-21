package com.gaan.liver.di.component;

import com.gaan.liver.di.module.ActivityModule;
import com.gaan.liver.di.module.NetworkModule;
import com.gaan.liver.di.scope.ActivityScope;
import com.gaan.liver.ui.ar.ArActivity;
import com.gaan.liver.ui.auth.forgotpassword.ForgotPasswordActivity;
import com.gaan.liver.ui.auth.login.LoginActivity;
import com.gaan.liver.ui.auth.register.RegisterActivity;
import com.gaan.liver.ui.auth.splash.SplashActivity;
import com.gaan.liver.ui.auth.splash.SplashViewModel;
import com.gaan.liver.ui.discover.DiscoverActivity;
import com.gaan.liver.ui.messenger.MessengerActivity;
import com.gaan.liver.ui.profile.ProfileActivity;
import com.gaan.liver.ui.settings.SettingsActivity;

import dagger.Component;

@ActivityScope
@Component(modules = {ActivityModule.class}, dependencies = {AppComponent.class})
public interface ActivityComponent {

    void inject(SplashActivity splashActivity);

    void inject(LoginActivity activity);

    void inject(ForgotPasswordActivity forgotPasswordActivity);

    void inject(RegisterActivity registerActivity);

    void inject(ArActivity arActivity);

    void inject(DiscoverActivity discoverActivity);

    void inject(MessengerActivity messengerActivity);

    void inject(ProfileActivity profileActivity);

    void inject(SettingsActivity settingsActivity);

    void inject(SplashViewModel splashViewModel);
}
