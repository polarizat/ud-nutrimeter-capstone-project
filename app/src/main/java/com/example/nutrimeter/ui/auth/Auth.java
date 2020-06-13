package com.example.nutrimeter.ui.auth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nutrimeter.R;
import com.example.nutrimeter.common.BaseFragment;
import com.example.nutrimeter.databinding.AuthFragmentBinding;
import com.example.nutrimeter.ui.MainActivityViewModel;

public class Auth extends BaseFragment {

    private AuthViewModel viewModel;
    private AuthFragmentBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = getViewModel(AuthViewModel.class, this);
        binding = AuthFragmentBinding.inflate(getLayoutInflater());


        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);

        binding.continueWithGoogleCv.setOnClickListener(continueWithGoogleView -> {
            navController.navigate(R.id.action_nav_auth_to_authWithGoogle);
        });

        binding.continueWithEmailCv.setOnClickListener(continueWithEmail -> {
            navController.navigate(R.id.action_nav_auth_to_authEmailAndPassword);
        });

        binding.continueWithoutAccountLl.setOnClickListener(continueAnonymous -> {
            navController.navigate(R.id.action_nav_auth_to_authAnonymous);
        });
    }
}