package com.example.nutrimeter.data.repo;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.nutrimeter.R;
import com.example.nutrimeter.data.model.User;
import com.example.nutrimeter.data.util.State;
import com.example.nutrimeter.ui.auth.ResourceAuth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import timber.log.Timber;

public class AuthRepo {

    FirebaseAuth mAuth;

    MutableLiveData<ResourceAuth<User>> authResult;
    MutableLiveData<ResourceAuth<FirebaseUser>> passwordResetResult;
    MutableLiveData<ResourceAuth<FirebaseUser>> hasAccountResult;
    MutableLiveData<User> userLiveData;

    MutableLiveData<State.AuthState> authenticationStateLiveData;

    DatabaseReference usersRef;

    @Inject
    public AuthRepo(FirebaseAuth auth, @Named("users") DatabaseReference usersRef){
        this.usersRef = usersRef;
        mAuth = auth;
        authResult = new MutableLiveData<>();
        passwordResetResult = new MutableLiveData<>();
        hasAccountResult = new MutableLiveData<>();
        userLiveData = new MutableLiveData<>();

        authenticationStateLiveData = new MutableLiveData<>();

        authenticationStateLiveData.setValue(mAuth.getCurrentUser() == null ? State.AuthState.UNAUTHENTICATED : State.AuthState.AUTHENTICATED);
    }

    public LiveData<State.AuthState> getAuthenticationState() {
        return authenticationStateLiveData;
    }

    public LiveData<ResourceAuth<User>> getAuthResult(){
        return authResult;
    }

    public LiveData<ResourceAuth<FirebaseUser>> getResetPasswordResult(){
        return passwordResetResult;
    }
    public LiveData<ResourceAuth<FirebaseUser>> hasAccountResult(){
        return hasAccountResult;
    }
    public LiveData<User> getUserLiveData(){
        return userLiveData;
    }

    public void setUserLiveData(User user) {
        this.userLiveData.setValue(user);
    }

    public void setAuthenticationState(State.AuthState authenticationState) {
        this.authenticationStateLiveData.setValue(authenticationState);
    }

    /**
 *
 * PASSWORD AUTHENTICATION methods
 *
 * */
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
                    FirebaseUser firebaseUser = mAuth.getCurrentUser();
                    User user = new User(firebaseUser.getUid(), name, email, firebaseUser.getProviderId());

                    authResult.setValue(new ResourceAuth<>(
                            ResourceAuth.Status.SUCCESS,
                            user,
                            "createUserWithEmail:success"));

                    //authenticationStateLiveData.setValue(MainActivityViewModel.AuthenticationState.AUTHENTICATED);
                    //addNewUserToFirebase(User.AuthType.PASSWORD, user); //TODO Case handeled in Auth Fragment

                } else {
                    Timber.w(task.getException(), "createUserWithEmail:failure");
                    authResult.setValue(new ResourceAuth<>(
                            ResourceAuth.Status.ERROR,
                            null,
                            "createUserWithEmail:failure"));

                    //authenticationStateLiveData.setValue(MainActivityViewModel.AuthenticationState.INVALID_AUTHENTICATION);

                }
                authResult.setValue(new ResourceAuth<>("default"));
                });
    }

    public void signIn(Context context, String email, String password){
        authResult.setValue(new ResourceAuth<>(ResourceAuth.Status.LOADING, null, "loading"));

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) context, task -> {
                    if (task.isSuccessful()) {
                        fetchUserDataFromFirebase(mAuth.getCurrentUser().getUid(), "signInWithEmail:success");
                    } else {
                        authResult.setValue(new ResourceAuth<>(ResourceAuth.Status.ERROR,
                                null, "signInWithEmail:failure"));
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


    /**
     *
     * GOOGLE AUTHENTICATION methods
     *
     * */
    public void firebaseAuthWithGoogle(String idToken) {
        Timber.d("firebaseAuthWithGoogle:%s", idToken);
        authResult.setValue(new ResourceAuth<>(ResourceAuth.Status.LOADING, null, "loading"));

        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Timber.d("signInWithCredential:success");
                        FirebaseUser firebaseUser = mAuth.getCurrentUser();
                        String photoUrl = User.DEFAULT_PHOTO_URL;
                        if (firebaseUser.getPhotoUrl() != null){
                            photoUrl = firebaseUser.getPhotoUrl().toString();
                        }
                        User user = new User(firebaseUser.getUid(), firebaseUser.getDisplayName(), firebaseUser.getEmail(), firebaseUser.getProviderId(), photoUrl);
                        userLiveData.setValue(user);
                        checkIfAccountExist(User.AuthType.GOOGLE);

                        //authenticationStateLiveData.setValue(MainActivityViewModel.AuthenticationState.AUTHENTICATED);

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

    public void disconnectGoogleAccount(Context context){
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(context, gso);
        mGoogleSignInClient.revokeAccess().addOnCompleteListener(task -> {
            authenticationStateLiveData.setValue(State.AuthState.UNAUTHENTICATED);
            //authenticationStateLiveData.setValue(MainActivityViewModel.AuthenticationState.UNAUTHENTICATED);

        });
    }


    /**
     *
     * ANONYMOUS AUTHENTICATION methods
     *
     * */
    public void signInAnonymously() {
        authResult.setValue(new ResourceAuth<>(ResourceAuth.Status.LOADING, null, "loading"));

        mAuth.signInAnonymously()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Timber.d("signInAnonymously:success");
                        FirebaseUser firebaseUser = mAuth.getCurrentUser();
                        assert firebaseUser != null;
                        User user = new User(firebaseUser.getUid());
                        userLiveData.setValue(user);
                        addOrUpdateUserToFirebase(User.AuthType.ANONYMOUS);
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



    /**
     *
     * FIREBASE REALTIME DATABASE -> UPDATE DATA methods
     *
     * */

    public void checkIfAccountExist(User.AuthType authType){
        switch (authType){

            case PASSWORD_CREATE_ACCOUNT:
                break;
            case PASSWORD_LOGIN:
                break;
            case GOOGLE:
                usersRef.child(userLiveData.getValue().getuId()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue() == null){
                            // User do not exist -> Create entry and config.
                            authResult.setValue(new ResourceAuth<>(ResourceAuth.Status.SUCCESS,
                                    null, "success, Create account and config"));
                        } else {
                            //Already exists -> Go to Main flow
                            usersRef.child(userLiveData.getValue().getuId()).child(User.KEY_FIELD_LAST_SIGN_IN).setValue(User.getTimestamp());
                            checkIfConfigExist();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) { }
                });

                break;
            case ANONYMOUS:
                break;
        }
    }

    public void checkIfConfigExist(){
        String userId = userLiveData.getValue().getuId();
        usersRef.child(userId).child(User.KEY_FIELD_GENDER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue(Integer.class) == 0){
                    // Confing do not exist
                    authResult.setValue(new ResourceAuth<>(ResourceAuth.Status.SUCCESS_NEED_CONFIG,
                            null, "success, Create account and config"));
                } else {
                    //Already exists -> Go to Main flow
                    usersRef.child(userLiveData.getValue().getuId()).child(User.KEY_FIELD_LAST_SIGN_IN).setValue(User.getTimestamp());
                    authenticationStateLiveData.setValue(State.AuthState.AUTHENTICATED);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });
    }

    public void addOrUpdateUserToFirebase(User.AuthType authType){
        switch (authType){
            case PASSWORD_LOGIN:
                usersRef.child(userLiveData.getValue().getuId())
                        .child(User.KEY_FIELD_LAST_SIGN_IN)
                        .setValue(User.getTimestamp());
                authenticationStateLiveData.setValue(State.AuthState.AUTHENTICATED);
                break;
            case GOOGLE:
            case PASSWORD_CREATE_ACCOUNT:
            case ANONYMOUS:
                usersRef.child(userLiveData.getValue().getuId())
                        .setValue(userLiveData.getValue());
                authenticationStateLiveData.setValue(State.AuthState.AUTHENTICATED);
                break;
        }
    }

    public void logout(){
        mAuth.signOut();
        authenticationStateLiveData.setValue(State.AuthState.UNAUTHENTICATED);
    }

    public void deleteAccount(String uId){
        usersRef.child(uId).setValue(null);
        userLiveData.setValue(null); // TODO Check if livedata can handle null value
        authenticationStateLiveData.setValue(State.AuthState.UNAUTHENTICATED);
    }

    private void fetchUserDataFromFirebase(String uid, String message) {
        usersRef.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                authResult.setValue(new ResourceAuth<>(ResourceAuth.Status.SUCCESS,
                        dataSnapshot.getValue(User.class), message));
                usersRef.child(uid).child(User.KEY_FIELD_LAST_SIGN_IN).setValue(User.getTimestamp());
                //authenticationStateLiveData.setValue(MainActivityViewModel.AuthenticationState.AUTHENTICATED);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //TODO Handle Error
                //authenticationStateLiveData.setValue(MainActivityViewModel.AuthenticationState.INVALID_AUTHENTICATION);
            }
        });

    }

    public void updateFirstConfig(User.Gender gender, int age, float height, float currentWeight){
        User user = userLiveData.getValue();
        assert user != null;
        user.setGender(gender);
        user.setAge(age);
        user.setHeight(height);
        user.setCurrentWeight(currentWeight);

        usersRef.setValue(user);
        userLiveData.setValue(user);
    }


}
