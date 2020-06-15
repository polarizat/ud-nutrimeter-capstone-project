package com.example.nutrimeter.ui.me;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.nutrimeter.common.BaseFragment;
import com.example.nutrimeter.databinding.FragmentMeBinding;

public class Me extends BaseFragment {

    private MeViewModel meViewModel;
    private FragmentMeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMeBinding.inflate(getLayoutInflater());
        meViewModel = getViewModel(MeViewModel.class, this);


        return binding.getRoot();
    }
}