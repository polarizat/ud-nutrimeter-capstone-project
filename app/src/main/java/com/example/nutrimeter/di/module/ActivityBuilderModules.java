package com.example.nutrimeter.di.module;

import com.example.nutrimeter.di.module.main.MainFragmentBuildersModule;
import com.example.nutrimeter.di.module.main.MainScope;
import com.example.nutrimeter.di.module.main.MainViewModelModule;
import com.example.nutrimeter.di.module.main.auth.AuthModule;
import com.example.nutrimeter.di.module.main.auth.AuthViewModelModule;
import com.example.nutrimeter.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBuilderModules {

    @MainScope
    @ContributesAndroidInjector(modules = {
            MainViewModelModule.class,
            MainFragmentBuildersModule.class,
            ViewModelBuildersModule.class,
            AuthViewModelModule.class,
            AuthModule.class,
    })
    abstract MainActivity contributeMainActivity();
}
