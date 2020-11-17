package com.gaan.liver.di.component;

import android.app.Application;

import com.gaan.liver.App;
import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.di.module.AppModule;
import com.gaan.liver.di.module.NetworkModule;
import com.gaan.liver.util.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class,AppModule.class})
public interface AppComponent {

    void inject(App app);

    IUserDataManager getUserDataManager();

    SchedulerProvider getSchedulerProvider();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
