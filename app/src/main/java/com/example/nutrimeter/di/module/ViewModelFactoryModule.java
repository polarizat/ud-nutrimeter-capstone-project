package com.example.nutrimeter.di.module;

import androidx.lifecycle.ViewModelProvider;

import com.example.nutrimeter.common.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);


}
