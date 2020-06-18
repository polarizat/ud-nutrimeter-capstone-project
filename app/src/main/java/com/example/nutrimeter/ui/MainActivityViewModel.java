package com.example.nutrimeter.ui;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nutrimeter.data.repo.AuthRepo;
import com.example.nutrimeter.data.util.State;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

public class MainActivityViewModel extends ViewModel {

    private FirebaseAuth mFirebaseAuth;
    private AuthRepo mAuthRepo;

    private MutableLiveData<FirebaseUser> mCurrentUserLiveData = new MutableLiveData<>();
    private LiveData<State.AuthState> authenticationStateLiveData;

    @Inject
    public MainActivityViewModel(FirebaseAuth firebaseAuth, AuthRepo authRepo){
        mFirebaseAuth = firebaseAuth;
        mCurrentUserLiveData.setValue(firebaseAuth.getCurrentUser());
        mAuthRepo = authRepo;

        authenticationStateLiveData = authRepo.getAuthenticationState();
    }

    public LiveData<State.AuthState> getAuthenticationStateLiveData() {
        return authenticationStateLiveData;
    }

    public LiveData<FirebaseUser> getCurrentUserLiveData(){
        return mCurrentUserLiveData;
    }

    public void logout(){
        mAuthRepo.logout();
    }

    public void disconnectGoogleAccount(Context context){
        mAuthRepo.disconnectGoogleAccount(context);
    }

}
