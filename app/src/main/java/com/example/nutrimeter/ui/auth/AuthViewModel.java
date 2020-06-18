package com.example.nutrimeter.ui.auth;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.nutrimeter.data.model.User;
import com.example.nutrimeter.data.repo.AuthRepo;
import com.example.nutrimeter.data.util.State;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {

    private AuthRepo mAuthRepo;

    private LiveData<ResourceAuth<User>> mAuthResultLiveData;
    private LiveData<ResourceAuth<FirebaseUser>> mResetPasswordResultLiveData;
    private LiveData<ResourceAuth<FirebaseUser>> mHasAccountResultResultLiveData;

    private User.AuthType authType;

    private String mName;
    private String mEmail;
    private String mPassword;

    @Inject
    public AuthViewModel(AuthRepo authRepo){
        mAuthRepo = authRepo;
        mAuthResultLiveData = authRepo.getAuthResult();
        mResetPasswordResultLiveData = authRepo.getResetPasswordResult();
        mHasAccountResultResultLiveData = authRepo.hasAccountResult();
    }

    public LiveData<User> getUserLiveData() {
        return mAuthRepo.getUserLiveData();
    }

    public User getUser() {
        return mAuthRepo.getUserLiveData().getValue();
    }

    public void setUser(User user) {
        this.mAuthRepo.setUserLiveData(user);
    }

    public User.AuthType getAuthType() {
        return authType;
    }

    public void setAuthType(User.AuthType authType) {
        this.authType = authType;
    }

    public void createAccount(Context context){
        mAuthRepo.createAccount(context, mName, mEmail, mPassword);
    }

    public void checkIfHasAccount(String email){
        mAuthRepo.checkIfHasAccount(email);
    }

    public void firebaseAuthWithGoogle(String acct){
        mAuthRepo.firebaseAuthWithGoogle(acct);
    }
    public void disconnectGoogleAccount(Context context){
        mAuthRepo.disconnectGoogleAccount(context);
    }

    public void singIn(Context context){
        mAuthRepo.signIn(context, mEmail, mPassword);
    }

    public void singInAnonymously(){
        mAuthRepo.signInAnonymously();
    }

    public LiveData<ResourceAuth<User>> getAuthResultLiveData(){
        return  mAuthResultLiveData;
    }
    public LiveData<ResourceAuth<FirebaseUser>> getResetPasswordResultLiveData(){
        return  mResetPasswordResultLiveData;
    }
    public LiveData<ResourceAuth<FirebaseUser>> getHasAccountResultResultLiveData(){
        return  mHasAccountResultResultLiveData;
    }

    public String getName() {
        return mName;
    }
    public void setName(String mName) {
        this.mName = mName;
    }
    public String getEmail() {
        return mEmail;
    }
    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }
    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public void resetPassword(String email) {
        mEmail = email;
        mAuthRepo.sendPasswordResetEmail(mEmail);
    }

    public void updateDatabaseWithUser() {
        mAuthRepo.addOrUpdateUserToFirebase(authType);
    }

    public void setAuthenticationState(State.AuthState state) {
        mAuthRepo.setAuthenticationState(state);
    }
}