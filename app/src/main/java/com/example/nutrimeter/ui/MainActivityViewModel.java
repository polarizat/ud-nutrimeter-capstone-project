package com.example.nutrimeter.ui;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nutrimeter.data.repo.AuthRepo;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

public class MainActivityViewModel extends ViewModel {

    private FirebaseAuth mFirebaseAuth;
    private AuthRepo mAuthRepo;

    private MutableLiveData<FirebaseUser> mCurrentUserLiveData = new MutableLiveData<>();


    @Inject
    public MainActivityViewModel(FirebaseAuth firebaseAuth, AuthRepo authRepo){
        mFirebaseAuth = firebaseAuth;
        mCurrentUserLiveData.setValue(firebaseAuth.getCurrentUser());
        mAuthRepo = authRepo;
    }

    public LiveData<FirebaseUser> getCurrentUserLiveData(){
        return mCurrentUserLiveData;
    }

    public void logout(){
        mFirebaseAuth.signOut();
        mCurrentUserLiveData.setValue(mFirebaseAuth.getCurrentUser());
    }

    public void disconnectGoogleAccount(Context context){
        mAuthRepo.disconnectGoogleAccount(context);
    }



}
