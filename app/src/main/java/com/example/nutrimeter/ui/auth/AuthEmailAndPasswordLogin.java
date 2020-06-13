package com.example.nutrimeter.ui.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;

import com.example.nutrimeter.R;
import com.example.nutrimeter.common.BaseFragment;
import com.example.nutrimeter.databinding.AuthEmailAndPasswordLoginBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseUser;

import timber.log.Timber;

public class AuthEmailAndPasswordLogin extends BaseFragment {

    AuthViewModel viewModel;
    AuthEmailAndPasswordLoginBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = AuthEmailAndPasswordLoginBinding.inflate(getLayoutInflater());
        viewModel = getViewModel(AuthViewModel.class, getActivity());
        Timber.d("(polarizat) ---> AuthEmailAndPassword ----> onCreateView: %s",viewModel);

        setupListeners();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupObservers();
    }

    private void setupListeners(){
        binding.btnAuthEmailPasswordLogin.setOnClickListener(v -> {
            viewModel.setPassword(binding.authEpPasswordEt.getText().toString());
            viewModel.singIn(getContext());
        });
        binding.btnAuthEmailPasswordForgotPassword.setOnClickListener(v -> {
            showEditDialog(viewModel.getEmail()); //TODO
        });
        binding.authEpContinueOther.setOnClickListener(v -> {
            Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.action_authEmailAndPasswordLogin_to_nav_auth);
        });
    }

    private void setupObservers(){
        viewModel.getAuthResultLiveData().observe(getViewLifecycleOwner(), firebaseUserResourceAuth -> {
            switch (firebaseUserResourceAuth.status){
                case LOADING:
                    showProgressBar();
                    break;
                case SUCCESS:
                    hideProgressBar();
                    viewModel.setUser(firebaseUserResourceAuth.data);
                    Navigation.findNavController(getView())
                            .navigate(R.id.action_pop_out_of_auth);
                    break;
                case ERROR:
                    Toast.makeText(getContext(), firebaseUserResourceAuth.message, Toast.LENGTH_SHORT).show();
                    hideProgressBar();

            }
        });

        viewModel.getResetPasswordResultLiveData().observe(getViewLifecycleOwner(), firebaseUserResourceAuth -> {
            switch (firebaseUserResourceAuth.status){
                case SUCCESS:
                case ERROR:
                    hideProgressBar();
                    Snackbar.make(getView(),firebaseUserResourceAuth.message, Snackbar.LENGTH_LONG ).show();
                    break;
                case LOADING:
                    showProgressBar();
                    break;
            }
        });
    }

    private void showEditDialog(String email) {
        showProgressBar();

        AuthEmailAndPasswordLoginDirections
                .ResetPasswordAction actionResetPassword
                    = AuthEmailAndPasswordLoginDirections.resetPasswordAction();
        actionResetPassword.setEmail(email);

        Navigation.findNavController(getView()).navigate(actionResetPassword);
        hideProgressBar();
    }

    @Override
    public void onResume() {
        super.onResume();
        String user = AuthEmailAndPasswordLoginArgs.fromBundle(getArguments()).getEmail();
        if (!user.isEmpty()){
            viewModel.resetPassword(user);
        }
    }

    private void showProgressBar(){
        binding.authPbEp.setVisibility(View.VISIBLE);
    }
    private void hideProgressBar(){
        binding.authPbEp.setVisibility(View.INVISIBLE);
    }

}
