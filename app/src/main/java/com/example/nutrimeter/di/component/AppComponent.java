package com.example.nutrimeter.di.component;

import android.app.Application;

import com.example.nutrimeter.NutriMeterApplication;
import com.example.nutrimeter.di.module.ActivityBuilderModules;
import com.example.nutrimeter.di.module.AppModule;
import com.example.nutrimeter.di.module.ViewModelFactoryModule;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

// Definition of the NutriMeterApplication graph

@Singleton
@Component(
        modules =  {
                AndroidSupportInjectionModule.class,
                ActivityBuilderModules.class,
                AppModule.class,
                ViewModelFactoryModule.class,
        })

public interface AppComponent extends AndroidInjector<NutriMeterApplication> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application (Application application);
        AppComponent build();
    }

}
