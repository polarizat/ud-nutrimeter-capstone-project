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
import com.example.nutrimeter.databinding.AuthConfigPlanBinding;
import com.example.nutrimeter.ui.auth.AuthViewModel;

public class SelectPlanFragment extends BaseFragment {

    AuthViewModel authViewModel;
    AuthConfigPlanBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = AuthConfigPlanBinding.inflate(getLayoutInflater());

        authViewModel = getViewModel(AuthViewModel.class, getActivity());
        setupButtons();

        return binding.getRoot();
    }

    private void setupButtons() {
        User user = authViewModel.getUser();

        binding.authConfigPlanLoseWeightBtn.setOnClickListener(v -> {
            user.setCurrentPlan(User.TAG_PLAN_LOSE_WEIGHT);
            authViewModel.setUser(user);
            Navigation.findNavController(getView())
                    .navigate(R.id.action_selectPlanFragment_to_enterWeightFragment);
        });
        binding.authConfigPlanMaintainWeightBtn.setOnClickListener(v -> {
            user.setCurrentPlan(User.TAG_PLAN_MAINTAIN_WEIGHT);
            authViewModel.setUser(user);
            Navigation.findNavController(getView())
                    .navigate(R.id.action_selectPlanFragment_to_enterWeightFragment);
        });
        binding.authConfigPlanGainWeightBtn.setOnClickListener(v -> {
            user.setCurrentPlan(User.TAG_PLAN_GAIN_WEIGHT);
            authViewModel.setUser(user);
            Navigation.findNavController(getView())
                    .navigate(R.id.action_selectPlanFragment_to_enterWeightFragment);
        });
    }
}
