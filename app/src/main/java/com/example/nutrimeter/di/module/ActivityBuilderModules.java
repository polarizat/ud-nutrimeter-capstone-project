package com.example.nutrimeter.di.module;

import com.example.nutrimeter.di.module.main.MainFragmentBuildersModule;
import com.example.nutrimeter.di.module.main.MainModule;
import com.example.nutrimeter.di.module.main.MainScope;
import com.example.nutrimeter.di.module.main.MainViewModelBuildersModule;
import com.example.nutrimeter.di.module.main.auth.AuthModule;
import com.example.nutrimeter.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBuilderModules {

    @MainScope
    @ContributesAndroidInjector(modules = {
            MainModule.class,

            MainFragmentBuildersModule.class,
            MainViewModelBuildersModule.class,

            AuthModule.class,
    })
    abstract MainActivity contributeMainActivity();
}
