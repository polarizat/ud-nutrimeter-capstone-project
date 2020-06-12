package com.example.nutrimeter.di.module;

import com.example.nutrimeter.di.module.auth.AuthViewModelsModule;
import com.example.nutrimeter.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelsModule.class,
                    FragmentModule.class,
            }
    )
    abstract MainActivity contributeMainActivity();
}
