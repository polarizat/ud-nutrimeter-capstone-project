package com.example.nutrimeter.ui.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.nutrimeter.R;
import com.example.nutrimeter.common.BaseFragment;
import com.example.nutrimeter.databinding.AuthFragmentBinding;

public class Auth extends BaseFragment {

    private AuthViewModel viewModel;
    private AuthFragmentBinding binding;

//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        // This callback will only be called when MyFragment is at least Started.
//        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
//            @Override
//            public void handleOnBackPressed() {
//                Navigation.findNavController(getView()).navigate(R.id.main_navigation);
//                Navigation.findNavController(getView()).popBackStack();
//
//            }
//        };
//        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
//
//    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = getViewModel(AuthViewModel.class, this);
        binding = AuthFragmentBinding.inflate(getLayoutInflater());


//        View decorView = getActivity().getWindow().getDecorView();
//        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
//                | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
//                | View.SYSTEM_UI_FLAG_IMMERSIVE;
//        decorView.setSystemUiVisibility(uiOptions);

        return binding.getRoot();
    }





    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupAuthOptions(); //TODO Check if it work in it is moved to onCreateView
    }

    private void setupAuthOptions() {
        NavController navController = Navigation.findNavController(getView());

        binding.continueWithGoogleCv.setOnClickListener(continueWithGoogleView -> {
            navController.navigate(R.id.action_nav_auth_to_authWithGoogle);
        });

        binding.continueWithEmailCv.setOnClickListener(continueWithEmail -> {
            navController.navigate(R.id.action_nav_auth_to_authEmailAndPassword);
        });

        binding.continueWithoutAccountLl.setOnClickListener(continueAnonymous -> {
            navController.navigate(R.id.action_nav_auth_to_authAnonymous);
        });
    }


}