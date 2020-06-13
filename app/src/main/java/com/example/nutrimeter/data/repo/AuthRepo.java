package com.example.nutrimeter.data.repo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.nutrimeter.R;
import com.example.nutrimeter.common.Resource;
import com.example.nutrimeter.ui.auth.ResourceAuth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.SignInMethodQueryResult;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import timber.log.Timber;

public class AuthRepo {

    FirebaseAuth mAuth;

    MutableLiveData<ResourceAuth<FirebaseUser>> authResult;
    MutableLiveData<ResourceAuth<FirebaseUser>> passwordResetResult;
    MutableLiveData<ResourceAuth<FirebaseUser>> hasAccountResult;
    MutableLiveData<FirebaseUser> firebaseUserLiveData;

    @Inject
    public AuthRepo(){
        mAuth = FirebaseAuth.getInstance();
        authResult = new MutableLiveData<>();
        passwordResetResult = new MutableLiveData<>();
        hasAccountResult = new MutableLiveData<>();
        firebaseUserLiveData = new MutableLiveData<>();
    }

    public LiveData<ResourceAuth<FirebaseUser>> getAuthResult(){
        return authResult;
    }
    public LiveData<ResourceAuth<FirebaseUser>> getResetPasswordResult(){
        return passwordResetResult;
    }
    public LiveData<ResourceAuth<FirebaseUser>> hasAccountResult(){
        return hasAccountResult;
    }

    public LiveData<FirebaseUser> getFirebaseUserLiveData(){
        return firebaseUserLiveData;
    }

    public void checkIfHasAccount (String email) {
        hasAccountResult.setValue(new ResourceAuth<>(ResourceAuth.Status.LOADING, null, "loading"));

        mAuth.fetchSignInMethodsForEmail(email)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        SignInMethodQueryResult result = task.getResult();
                        List<String> signInMethods = result.getSignInMethods();

                        if (signInMethods.contains(EmailAuthProvider.EMAIL_PASSWORD_SIGN_IN_METHOD)) {
                            hasAccountResult.setValue(new ResourceAuth<>(
                                    ResourceAuth.Status.SUCCESS,
                                    null,
                                    "Email account already exist"));
                            Timber.e(task.getException(), "Email account already exist");
                    } else {
                            hasAccountResult.setValue(new ResourceAuth<>
                                    (ResourceAuth.Status.ERROR,
                                            null,
                                            "Error getting sign in methods for user"));
                        }
                        Timber.e(task.getException(), "Error getting sign in methods for user");
                    }
                    hasAccountResult.setValue(new ResourceAuth<>("default"));
                });
    }

    public void createAccount(Context context, String name, String email, String password){
        authResult.setValue(new ResourceAuth<>(ResourceAuth.Status.LOADING, null, "loading"));
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) context, task -> {

                if (task.isSuccessful()) {
                    FirebaseUser user = mAuth.getCurrentUser();
                    authResult.setValue(new ResourceAuth<>(
                            ResourceAuth.Status.SUCCESS,
                            user,
                            "createUserWithEmail:success"));
                    firebaseUserLiveData.setValue(user);
                } else {
                    Timber.w(task.getException(), "createUserWithEmail:failure");
                    authResult.setValue(new ResourceAuth<FirebaseUser>(
                            ResourceAuth.Status.ERROR,
                            null,
                            "createUserWithEmail:success"));
                }
                authResult.setValue(new ResourceAuth<>("default"));
                });
    };

    public void signIn(Context context, String email, String password){
        authResult.setValue(new ResourceAuth<>(ResourceAuth.Status.LOADING, null, "loading"));

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) context, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        authResult.setValue(new ResourceAuth<>(
                                ResourceAuth.Status.SUCCESS,
                                user,
                                "signInWithEmail:success"));
                        firebaseUserLiveData.setValue(user);

                    } else {
                        authResult.setValue(new ResourceAuth<>(
                                ResourceAuth.Status.ERROR,
                                null,
                                "signInWithEmail:failure"));
                    }
                });
        authResult.setValue(new ResourceAuth<>("default"));
    }

    public void sendPasswordResetEmail(final String emailAddress) {
        passwordResetResult.setValue(new ResourceAuth<>(ResourceAuth.Status.LOADING, null, "loading"));

        mAuth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        passwordResetResult.setValue(new ResourceAuth<>(
                                ResourceAuth.Status.SUCCESS,
                                null,
                                "Email was send! Check your inbox and come back."));
                    } else {
                        passwordResetResult.setValue(new ResourceAuth<>(
                                ResourceAuth.Status.ERROR,
                                null,
                                "Failed. Please try again!"));
                    }
                });
        passwordResetResult.setValue(new ResourceAuth<>("default"));

    }

    public void disconnectGoogleAccount(Context context){
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(context, gso);
        mGoogleSignInClient.revokeAccess().addOnCompleteListener(task -> {

        });
    }

    public void firebaseAuthWithGoogle(String idToken) {
        Timber.d("firebaseAuthWithGoogle:%s", idToken);
        authResult.setValue(new ResourceAuth<>(ResourceAuth.Status.LOADING, null, "loading"));

        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        authResult.setValue(new ResourceAuth<>(
                                ResourceAuth.Status.SUCCESS,
                                user,
                                "signInWithCredential:success"));
                        Timber.d("signInWithCredential:success");
                    } else {
                        Timber.w(task.getException(), "signInWithCredential:failure");
                        authResult.setValue(new ResourceAuth<>(
                                ResourceAuth.Status.ERROR,
                                null,
                                "signInWithCredential:failure"));
                    }
                });
        authResult.setValue(new ResourceAuth<>("default"));
    }

    public void signInAnonymously() {
        authResult.setValue(new ResourceAuth<>(ResourceAuth.Status.LOADING, null, "loading"));

        mAuth.signInAnonymously()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Timber.d("signInAnonymously:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        authResult.setValue(new ResourceAuth<>(
                                ResourceAuth.Status.SUCCESS,
                                user,
                                "signInWithCredential:success"));
                    } else {
                        Timber.w(task.getException(), "signInAnonymously:failure");
                        authResult.setValue(new ResourceAuth<>(
                                ResourceAuth.Status.ERROR,
                                null,
                                "signInWithCredential:failure"));
                    }
                });
        authResult.setValue(new ResourceAuth<>("default"));

    }





}
