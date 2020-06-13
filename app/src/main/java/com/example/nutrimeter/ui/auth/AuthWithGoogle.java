package com.example.nutrimeter.ui.auth;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;

import com.example.nutrimeter.R;
import com.example.nutrimeter.common.BaseFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import timber.log.Timber;

public class AuthWithGoogle extends BaseFragment {

    private static final int RC_SIGN_IN = 808;

    AuthViewModel viewModel;

    public AuthWithGoogle() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = getViewModel(AuthViewModel.class, getActivity());

        signIn();
        setupObservers();

        return inflater.inflate(R.layout.auth_with_google_fragmet, container, false);
    }

    private void signIn() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);

        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void setupObservers() {
        viewModel.getAuthResultLiveData().observe(getViewLifecycleOwner(), firebaseUserResourceAuth -> {
            switch (firebaseUserResourceAuth.status){
                case SUCCESS:
                    Navigation.findNavController(getView()).navigate(R.id.action_pop_out_of_auth);
                    break;
                case ERROR:
                    Snackbar.make(getView(), "Google sign in failed! Try again!", Snackbar.LENGTH_LONG ).show();
                    Navigation.findNavController(getView()).navigate(R.id.action_authWithGoogle_to_nav_auth);
                    break;
                case LOADING:
                case DEFAULT:
                    break;
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                String idToken = task.getResult(ApiException.class).getIdToken();
                viewModel.firebaseAuthWithGoogle(idToken);

            } catch (ApiException e) {
                Timber.w(e, "Google sign in failed"); //This case is handle with observer
            }
        }
    }

}