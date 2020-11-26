package com.gaan.liver.di.component;

import android.app.Application;

import com.gaan.liver.BaseApplication;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.di.module.ActivityBuildersModule;
import com.gaan.liver.di.module.AppModule;
import com.gaan.liver.di.module.NetworkModule;
import com.gaan.liver.di.module.RepositoryModule;
import com.gaan.liver.di.module.ViewModelFactoryModule;
import com.gaan.liver.util.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
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
public interface AppComponent extends AndroidInjector<BaseApplication> {

    IUserDataManager getUserDataManager();

    SchedulerProvider getSchedulerProvider();

    void inject(BaseApplication app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
