package com.example.nutrimeter.ui.my_food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.nutrimeter.common.BaseFragment;
import com.example.nutrimeter.databinding.FragmentMyFoodBinding;

public class MyFood extends BaseFragment {

    private MyFoodViewModel viewModel;
    private FragmentMyFoodBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMyFoodBinding.inflate(getLayoutInflater());
        viewModel = getViewModel(MyFoodViewModel.class);



        return binding.getRoot();
    }
}