package com.example.nutrimeter.di.module.diary;

import androidx.lifecycle.ViewModel;

import com.example.nutrimeter.di.ViewModelKey;
import com.example.nutrimeter.ui.diary.DiaryViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import timber.log.Timber;

@Module
public abstract class DiaryViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(DiaryViewModel.class)
    public abstract ViewModel bindDiaryViewModel(DiaryViewModel viewModel);


}
