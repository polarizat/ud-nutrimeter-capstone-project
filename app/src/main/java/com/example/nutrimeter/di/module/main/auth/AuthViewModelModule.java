package com.example.nutrimeter.di.module.main.auth;

import androidx.lifecycle.ViewModel;

import com.example.nutrimeter.di.ViewModelKey;
import com.example.nutrimeter.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);


}
