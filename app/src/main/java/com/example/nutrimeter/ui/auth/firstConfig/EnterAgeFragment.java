package com.example.nutrimeter.ui.auth.firstConfig;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.example.nutrimeter.R;
import com.example.nutrimeter.common.BaseFragment;
import com.example.nutrimeter.data.model.User;
import com.example.nutrimeter.databinding.AuthConfigAgeBinding;
import com.example.nutrimeter.ui.auth.AuthViewModel;
import com.example.nutrimeter.util.DataValidation;


public class EnterAgeFragment extends BaseFragment {

    AuthViewModel authViewModel;
    AuthConfigAgeBinding binding;

    User user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = AuthConfigAgeBinding.inflate(getLayoutInflater());

        authViewModel = getViewModel(AuthViewModel.class, getActivity());
        user = authViewModel.getUser();

        binding.authConfigAgeNextBtn.setOnClickListener(v -> {
            String age = binding.authConfigAgeEt.getText().toString();
            if (DataValidation.isDataValid(DataValidation.DataType.AGE, age)) {
                user.setAge(Integer.parseInt(age));
                authViewModel.setUser(user);
                Navigation.findNavController(getView())
                        .navigate(R.id.action_enterAgeFragment_to_enterHeightFragment);
            } else {
                binding.authConfigAgeEt.setError(getString(R.string.error_invalid_age));
            }
        });

        return binding.getRoot();
    }
}
