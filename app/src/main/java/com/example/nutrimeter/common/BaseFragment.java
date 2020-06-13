package com.example.nutrimeter.common;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class BaseFragment extends DaggerFragment {

    @Inject
    ViewModelProviderFactory providerFactory;

     protected <T extends ViewModel> T getViewModel(Class<T> vmClass, Fragment scopeOf) {
         return new ViewModelProvider(scopeOf, providerFactory).get(vmClass);
     }

     protected <T extends ViewModel> T getViewModel(Class<T> vmClass, Activity scopeOf) {
         return new ViewModelProvider((ViewModelStoreOwner) scopeOf, providerFactory).get(vmClass);
     }

     protected <T extends ViewModel> T getViewModel(Class<T> vmClass) {
         return new ViewModelProvider(this, providerFactory).get(vmClass);
     }

}
