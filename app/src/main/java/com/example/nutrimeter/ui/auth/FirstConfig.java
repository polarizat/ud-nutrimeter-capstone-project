package com.example.nutrimeter.ui.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nutrimeter.R;
import com.example.nutrimeter.common.BaseFragment;


public class FirstConfig extends BaseFragment {

    AuthViewModel authViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        authViewModel = getViewModel(AuthViewModel.class, getActivity());
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.auth_config_gender, container, false);
    }
}