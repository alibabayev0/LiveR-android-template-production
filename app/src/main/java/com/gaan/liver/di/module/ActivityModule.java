package com.gaan.liver.di.module;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;

import com.gaan.liver.ViewModelProviderFactory;
import com.gaan.liver.ui.base.BaseActivity;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.ui.ar.ArViewModel;
import com.gaan.liver.ui.auth.forgotpassword.ForgotPasswordViewModel;
import com.gaan.liver.ui.auth.login.LoginViewModel;
import com.gaan.liver.ui.auth.register.RegisterViewModel;
import com.gaan.liver.ui.auth.splash.SplashViewModel;
import com.gaan.liver.ui.discover.DiscoverViewModel;
import com.gaan.liver.ui.messenger.MessengerViewModel;
import com.gaan.liver.ui.profile.ProfileViewModel;
import com.gaan.liver.ui.settings.SettingsViewModel;
import com.gaan.liver.util.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private BaseActivity<?, ?> activity;

    public ActivityModule(BaseActivity<?, ?> activity) {
        this.activity = activity;
    }

    @Provides
    SplashViewModel provideSplashViewModel(IUserDataManager userDataManager, SchedulerProvider schedulerProvider) {
        Supplier<SplashViewModel> supplier = () -> new SplashViewModel(userDataManager,schedulerProvider);
        ViewModelProviderFactory<SplashViewModel> factory = new ViewModelProviderFactory<>(SplashViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(SplashViewModel.class);
    }

    @Provides
    LoginViewModel provideLoginViewModel(IUserDataManager userDataManager,SchedulerProvider schedulerProvider) {
        Supplier<LoginViewModel> supplier = () -> new LoginViewModel(userDataManager,schedulerProvider);
        ViewModelProviderFactory<LoginViewModel> factory = new ViewModelProviderFactory<>(LoginViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(LoginViewModel.class);
    }

    @Provides
    ForgotPasswordViewModel provideForgotPasswordViewModel(IUserDataManager userDataManager,SchedulerProvider schedulerProvider) {
        Supplier<ForgotPasswordViewModel> supplier = () -> new ForgotPasswordViewModel(userDataManager,schedulerProvider);
        ViewModelProviderFactory<ForgotPasswordViewModel> factory = new ViewModelProviderFactory<>(ForgotPasswordViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(ForgotPasswordViewModel.class);
    }

    @Provides
    RegisterViewModel provideRegisterViewModel(IUserDataManager userDataManager,SchedulerProvider schedulerProvider) {
        Supplier<RegisterViewModel> supplier = () -> new RegisterViewModel(userDataManager,schedulerProvider);
        ViewModelProviderFactory<RegisterViewModel> factory = new ViewModelProviderFactory<>(RegisterViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(RegisterViewModel.class);
    }

    @Provides
    ArViewModel provideArViewModel(IUserDataManager userDataManager,SchedulerProvider schedulerProvider) {
        Supplier<ArViewModel> supplier = () -> new ArViewModel(userDataManager,schedulerProvider);
        ViewModelProviderFactory<ArViewModel> factory = new ViewModelProviderFactory<>(ArViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(ArViewModel.class);
    }

    @Provides
    DiscoverViewModel provideDiscoverViewModel(IUserDataManager userDataManager,SchedulerProvider schedulerProvider) {
        Supplier<DiscoverViewModel> supplier = () -> new DiscoverViewModel(userDataManager,schedulerProvider);
        ViewModelProviderFactory<DiscoverViewModel> factory = new ViewModelProviderFactory<>(DiscoverViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(DiscoverViewModel.class);
    }

    @Provides
    MessengerViewModel provideMessengerViewModel(IUserDataManager userDataManager,SchedulerProvider schedulerProvider) {
        Supplier<MessengerViewModel> supplier = () -> new MessengerViewModel(userDataManager,schedulerProvider);
        ViewModelProviderFactory<MessengerViewModel> factory = new ViewModelProviderFactory<>(MessengerViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(MessengerViewModel.class);
    }

    @Provides
    ProfileViewModel provideProfileViewModel(IUserDataManager userDataManager,SchedulerProvider schedulerProvider) {
        Supplier<ProfileViewModel> supplier = () -> new ProfileViewModel(userDataManager,schedulerProvider);
        ViewModelProviderFactory<ProfileViewModel> factory = new ViewModelProviderFactory<>(ProfileViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(ProfileViewModel.class);
    }

    @Provides
    SettingsViewModel provideSettingsViewModel(IUserDataManager userDataManager,SchedulerProvider schedulerProvider) {
        Supplier<SettingsViewModel> supplier = () -> new SettingsViewModel(userDataManager,schedulerProvider);
        ViewModelProviderFactory<SettingsViewModel> factory = new ViewModelProviderFactory<>(SettingsViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(SettingsViewModel.class);
    }
}