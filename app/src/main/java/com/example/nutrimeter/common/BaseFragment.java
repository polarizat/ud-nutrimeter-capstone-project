package com.example.nutrimeter.common;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class BaseFragment extends DaggerFragment {

    @Inject
    ViewModelProviderFactory providerFactory;

     protected <T extends ViewModel> T getViewModel(Class<T> vmClass, Fragment scopeOf) {
         return new ViewModelProvider(scopeOf, providerFactory).get(vmClass);
     }

}
