package com.example.nutrimeter.ui.auth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nutrimeter.R;
import com.example.nutrimeter.common.BaseFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseUser;

public class AuthAnonymous extends BaseFragment {

    AuthViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = getViewModel(AuthViewModel.class, getActivity());

        singInAnonymously();
        setupObservers();

        return inflater.inflate(R.layout.auth_anonymous_fragment, container, false);
    }

    public void singInAnonymously(){
        viewModel.singInAnonymously();
    }

    public void setupObservers(){
        viewModel.getAuthResultLiveData().observe(getViewLifecycleOwner(), firebaseUserResourceAuth -> {
            switch (firebaseUserResourceAuth.status){
                case SUCCESS:
                    Navigation.findNavController(getView()).navigate(R.id.action_pop_out_of_auth);
                    break;
                case ERROR:
                    Snackbar.make(getView(), "An error has occurred! Please try again!", Snackbar.LENGTH_LONG ).show();
                    Navigation.findNavController(getView()).navigate(R.id.action_authAnonymous_to_nav_auth);
                    break;
                case LOADING:
                case DEFAULT:
                    break;
            }
        });
    }

}