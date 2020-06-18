package com.example.nutrimeter.ui.auth.firstConfig;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.nutrimeter.R;
import com.example.nutrimeter.common.BaseFragment;
import com.example.nutrimeter.data.model.User;
import com.example.nutrimeter.databinding.AuthConfigWeightBinding;
import com.example.nutrimeter.ui.auth.AuthViewModel;
import com.example.nutrimeter.util.DataValidation;

public class EnterWeightFragment extends BaseFragment {

    AuthViewModel authViewModel;
    AuthConfigWeightBinding binding;

    User user;
    String selectedWeightSystem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = AuthConfigWeightBinding.inflate(getLayoutInflater());

        authViewModel = getViewModel(AuthViewModel.class, getActivity());
        user = authViewModel.getUser();

        selectedWeightSystem = getString(R.string.measure_system_metric);
        binding.setMeasureUnits(selectedWeightSystem);
        binding.radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioButton_imperial) {
                selectedWeightSystem = getString(R.string.weight_lbs);
            } else {
                selectedWeightSystem = getString(R.string.weight_kg);
            }
            binding.setMeasureUnits(selectedWeightSystem);
            binding.notifyChange();
        });

        binding.authConfigWeightFinishBtn.setOnClickListener(view -> {
            String currentWeight = binding.editTextCurrentWeight.getText().toString();
            String goalWeight = binding.authConfigGoalWeightEt.getText().toString();

            DataValidation.DataType dataType =
                    selectedWeightSystem.equals(getString(R.string.measure_system_metric))
                            ? DataValidation.DataType.WEIGHT_METRIC : DataValidation.DataType.WEIGHT_IMPERIAL;

            if (binding.radioButtonMetric.isChecked()) {
                if (DataValidation.isDataValid(dataType, currentWeight)) {
                    if (DataValidation.isDataValid(dataType, goalWeight)) {
                        user.setCurrentWeight(Float.parseFloat(currentWeight));
                        user.setGoalWeight(Float.parseFloat(goalWeight));

                        authViewModel.setUser(user);
                        authViewModel.updateDatabaseWithUser();

//                        Navigation.findNavController(requireView())
//                                .navigate(R.id.action_pop_out_of_auth);

                    } else {
                        binding.authConfigGoalWeightEt.setError(getString(R.string.error_goal_weight));
                    }
                } else {
                    binding.editTextCurrentWeight.setError(getString(R.string.error_goal_weight));
                }
            }
        });
        return binding.getRoot();
    }
}
