package com.example.nutrimeter.di.module.main;

import androidx.lifecycle.ViewModel;

import com.example.nutrimeter.di.ViewModelKey;
import com.example.nutrimeter.ui.MainActivityViewModel;
import com.example.nutrimeter.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    public abstract ViewModel bindMainViewModel(MainActivityViewModel viewModel);


}
