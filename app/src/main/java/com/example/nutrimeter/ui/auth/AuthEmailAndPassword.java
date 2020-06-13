package com.example.nutrimeter.ui.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.example.nutrimeter.R;
import com.example.nutrimeter.common.BaseFragment;
import com.example.nutrimeter.databinding.AuthEmailAndPasswordBinding;
import com.example.nutrimeter.util.DataValidation;
import com.google.android.material.snackbar.Snackbar;

import timber.log.Timber;

public class AuthEmailAndPassword extends BaseFragment
        implements ResetPasswordDialog.PasswordResetDialogListener{

    private AuthViewModel viewModel;
    private AuthEmailAndPasswordBinding binding;

    private String mEmail;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = AuthEmailAndPasswordBinding.inflate(getLayoutInflater());
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

        binding.authEpContinueOther.setOnClickListener(v -> {
            Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.action_authEmailAndPassword_to_nav_auth);
        });

        binding.btnAuthEpNext.setOnClickListener(v -> {
            mEmail = binding.authEpEmailEt.getText().toString();
            if (DataValidation.isDataValid(DataValidation.DataType.EMAIL, mEmail)){
                viewModel.checkIfHasAccount(mEmail);
                binding.authEpEmailIl.setError(null);
            } else {
                binding.authEpEmailIl.setError(getString(R.string.auth_error_email_invalid));
            }
        });
    }

    private void setupObservers(){

        viewModel.getHasAccountResultResultLiveData().observe(getViewLifecycleOwner(), firebaseUserResourceAuth -> {
            switch (firebaseUserResourceAuth.status) {
                case SUCCESS:
                    hideProgressBar();
                    Navigation.findNavController(getView())
                            .navigate(R.id.action_authEmailAndPassword_to_authEmailAndPasswordLogin);
                    break;
                case ERROR:
                    hideProgressBar();
                    Navigation.findNavController(getView())
                            .navigate(R.id.action_authEmailAndPassword_to_authEmailAndPasswordCreateAccount);
                    break;
                case LOADING:
                    showProgressBar();
                    break;
            }
            viewModel.setEmail(mEmail);
        });

    }

    private void showProgressBar(){
        binding.authPbEp.setVisibility(View.VISIBLE);
    }
    private void hideProgressBar(){
        binding.authPbEp.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onFinishEditDialog(String userEmail) {
        viewModel.resetPassword(userEmail);
    }
}
