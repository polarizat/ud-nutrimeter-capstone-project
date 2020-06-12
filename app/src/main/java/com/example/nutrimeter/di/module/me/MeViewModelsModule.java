package com.example.nutrimeter.di.module.me;

import androidx.lifecycle.ViewModel;

import com.example.nutrimeter.di.ViewModelKey;
import com.example.nutrimeter.ui.me.MeViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MeViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MeViewModel.class)
    public abstract ViewModel bindMeViewModel(MeViewModel viewModel);

}
