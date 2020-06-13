package com.example.nutrimeter.ui.diary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.nutrimeter.R;
import com.example.nutrimeter.common.BaseFragment;
import com.example.nutrimeter.common.ViewModelProviderFactory;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

public class Diary extends BaseFragment {

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;
    private DiaryViewModel diaryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        diaryViewModel = getViewModel(DiaryViewModel.class, this);

        View root = inflater.inflate(R.layout.fragment_diary, container, false);
        final TextView textView = root.findViewById(R.id.text_diary);


        Button goToAuthBtn = root.findViewById(R.id.go_to_auth_btn);
        goToAuthBtn.setOnClickListener(v ->
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.action_nav_diary_to_auth_graph));

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        Button showName = root.findViewById(R.id.show_name);
        showName.setOnClickListener(v ->
                        Toast.makeText(getContext(), user.getEmail() + " " + user.getProviderId() + "  " + user.getDisplayName(), Toast.LENGTH_SHORT).show()
                );




        diaryViewModel.getText().observe(getViewLifecycleOwner(), s -> textView.setText(s));
        return root;
    }
}