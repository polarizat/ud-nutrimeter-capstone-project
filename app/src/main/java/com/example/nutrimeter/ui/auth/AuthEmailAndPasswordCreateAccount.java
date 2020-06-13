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
import com.example.nutrimeter.databinding.AuthEmailAndPasswordCreateAccountBinding;
import com.example.nutrimeter.util.DataValidation;

import timber.log.Timber;

public class AuthEmailAndPasswordCreateAccount extends BaseFragment {

    AuthViewModel viewModel;
    AuthEmailAndPasswordCreateAccountBinding binding;

    private String mName;
    private String mPassword;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = AuthEmailAndPasswordCreateAccountBinding.inflate(getLayoutInflater());
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
        binding.btnAuthEpCreateAccount.setOnClickListener(v -> {
            mName = binding.authEpNameEt.getText().toString();
            mPassword = binding.authEpPasswordEt.getText().toString();

            if (DataValidation.isDataValid(DataValidation.DataType.NAME, mName)) {
                binding.authEpNameIl.setError(null);
                if (DataValidation.isDataValid(DataValidation.DataType.PASSWORD, mPassword)){
                    viewModel.setName(mName);
                    viewModel.setPassword(mPassword);
                    viewModel.createAccount(getContext());
                } else {
                    binding.authEpPasswordIl.setError(getString(R.string.auth_error_password_invalid));
                }
            } else {
                binding.authEpNameIl.setError(getString(R.string.auth_error_name_empty));
            }
        });

        binding.authEpContinueOther.setOnClickListener(v -> {
            Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.action_authEmailAndPasswordCreateAccount_to_nav_auth);
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


    }

    private void showProgressBar(){
        binding.authPbEp.setVisibility(View.VISIBLE);
    }
    private void hideProgressBar(){
        binding.authPbEp.setVisibility(View.INVISIBLE);
    }

}
