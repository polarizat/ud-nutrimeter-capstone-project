package com.example.nutrimeter.ui.auth;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import timber.log.Timber;

public class AuthViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    @Inject
    public AuthViewModel(){
        Timber.d("(polarizat) ---> DiaryViewModelsModule ----> : IT's Working");
    }


}