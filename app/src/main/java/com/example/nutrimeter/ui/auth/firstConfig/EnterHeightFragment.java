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
import com.example.nutrimeter.databinding.AuthConfigHeightBinding;
import com.example.nutrimeter.nutritioncalculatorjava.NutritionCalculator;
import com.example.nutrimeter.ui.auth.AuthViewModel;
import com.example.nutrimeter.util.DataValidation;

public class EnterHeightFragment extends BaseFragment {

    private static final int MEASURE_METRIC = 100;
    private static final int MEASURE_IMPERIAL = 30;

    AuthViewModel authViewModel;
    AuthConfigHeightBinding binding;

    User user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = AuthConfigHeightBinding.inflate(getLayoutInflater());
        authViewModel = getViewModel(AuthViewModel.class, getActivity());

        user = authViewModel.getUser();

        binding.radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioButton_imperial) {
                showAppropriateUnit(MEASURE_IMPERIAL);
            } else {
                showAppropriateUnit(MEASURE_METRIC);
            }
        });

        binding.authConfigHeightNextBtn.setOnClickListener(view -> {

            if (binding.radioButtonMetric.isChecked()) {
                String heightCm = binding.editTextHeightCm.getText().toString();
                if (DataValidation.isDataValid(DataValidation.DataType.HEIGHT_METRIC, heightCm)){
                    Navigation.findNavController(requireView())
                            .navigate(R.id.action_enterHeightFragment_to_selectPlanFragment);
                } else {
                    binding.editTextHeightCm.setError(getString(R.string.error_invalid_value_cm));
                }
            } else {
                String heightFeet = binding.editTextHeightFeet.getText().toString();
                String heightInches = binding.editTextHeightInches.getText().toString();

                if (DataValidation.isDataValid(DataValidation.DataType.HEIGHT_IMPERIAL_FEET, heightFeet)){
                    if (DataValidation.isDataValid(DataValidation.DataType.HEIGHT_IMPERIAL_INCHES, heightInches)){

                        user.setCurrentWeight(NutritionCalculator
                                .getMetricHeight(Float.parseFloat(heightFeet), Float.parseFloat(heightInches)));
                        authViewModel.setUser(user);

                        Navigation.findNavController(requireView())
                                .navigate(R.id.action_enterHeightFragment_to_selectPlanFragment);

                    } else {
                        binding.editTextHeightInches.setError(getString(R.string.error_invalid_inches_value));
                    }
                } else {
                    binding.editTextHeightFeet.setError(getString(R.string.error_invalid_feet_value));
                }
            }
        });
        return binding.getRoot();
    }

    private void showAppropriateUnit(int measure) {
        if (measure == MEASURE_IMPERIAL) {
            binding.authConfigHeightMetricGroup.setVisibility(View.GONE);
            binding.authConfigHeightImperialGroup.setVisibility(View.VISIBLE);
            binding.executePendingBindings();
        } else {
            binding.authConfigHeightImperialGroup.setVisibility(View.GONE);
            binding.authConfigHeightMetricGroup.setVisibility(View.VISIBLE);
            binding.executePendingBindings();

        }
    }

}
