package com.gaan.liver.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.gaan.liver.ViewModelFactory;
import com.gaan.liver.di.ViewModelKey;
import com.gaan.liver.ui.ar.ArViewModel;
import com.gaan.liver.ui.auth.forgotpassword.ForgotPasswordViewModel;
import com.gaan.liver.ui.auth.login.LoginViewModel;
import com.gaan.liver.ui.auth.register.RegisterViewModel;
import com.gaan.liver.ui.auth.splash.SplashViewModel;
import com.gaan.liver.ui.discover.DiscoverViewModel;
import com.gaan.liver.ui.messenger.MessengerViewModel;
import com.gaan.liver.ui.profile.ProfileViewModel;
import com.gaan.liver.ui.settings.SettingsViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel.class)
    public abstract ViewModel bindSplashViewModel(SplashViewModel splashViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    public abstract ViewModel bindLoginViewModel(LoginViewModel loginViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel.class)
    public abstract ViewModel bindRegisterViewModel(RegisterViewModel registerViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ForgotPasswordViewModel.class)
    public abstract ViewModel bindForgotPasswordViewModel(ForgotPasswordViewModel forgotPasswordViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DiscoverViewModel.class)
    public abstract ViewModel bindDiscoverViewModel(DiscoverViewModel discoverViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MessengerViewModel.class)
    public abstract ViewModel bindMessengerViewModel(MessengerViewModel splashViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel profileViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel.class)
    public abstract ViewModel bindSettingsViewModel(SettingsViewModel settingsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ArViewModel.class)
    public abstract ViewModel bindArViewModel(ArViewModel settingsViewModel);

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);
}
