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
import com.example.nutrimeter.databinding.AuthConfigGenderBinding;
import com.example.nutrimeter.ui.auth.AuthViewModel;

public class SelectGenderFragment extends BaseFragment {

    AuthViewModel authViewModel;
    AuthConfigGenderBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = AuthConfigGenderBinding.inflate(getLayoutInflater());

        authViewModel = getViewModel(AuthViewModel.class, getActivity());
        User user = authViewModel.getUser();

        if (user.getGender() == User.GENDER_DEFAULT){
            binding.authConfigGenderFemaleBtn.setOnClickListener(v -> {
                user.setGender(User.Gender.FEMALE);
                authViewModel.setUser(user);
                Navigation.findNavController(getView())
                        .navigate(R.id.action_selectGenderFragment_to_enterAgeFragment);
            });
            binding.authConfigGenderMaleBtn.setOnClickListener(v -> {
                user.setGender(User.Gender.MALE);
                authViewModel.setUser(user);
                Navigation.findNavController(getView())
                        .navigate(R.id.action_selectGenderFragment_to_enterAgeFragment);
            });
        } else {
            //User already configures his data -> Exit Config and Auth
            // TODO when press back
           // Navigation.findNavController(getView()).navigate(R.id.action_pop_out_of_auth);
        }
        return binding.getRoot();
    }
}
