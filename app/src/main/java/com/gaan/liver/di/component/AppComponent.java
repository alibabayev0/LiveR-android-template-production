package com.gaan.liver.di.component;

import android.app.Application;

import com.gaan.liver.MvvmApp;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.di.builder.ActivityBuildersModule;
import com.gaan.liver.di.module.AppModule;
import com.gaan.liver.di.module.NetworkModule;
import com.gaan.liver.di.module.RepositoryModule;
import com.gaan.liver.di.module.SensorModule;
import com.gaan.liver.di.module.ViewModelFactoryModule;
import com.gaan.liver.util.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuildersModule.class,
                AppModule.class,
                NetworkModule.class,
                RepositoryModule.class,
                ViewModelFactoryModule.class
        }
)
public interface AppComponent extends AndroidInjector<MvvmApp> {

    IUserDataManager getUserDataManager();

    SchedulerProvider getSchedulerProvider();

    void inject(MvvmApp app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
