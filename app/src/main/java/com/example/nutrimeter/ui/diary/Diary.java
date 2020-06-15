package com.example.nutrimeter.ui.diary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.nutrimeter.common.BaseFragment;
import com.example.nutrimeter.databinding.FragmentDiaryBinding;

public class Diary extends BaseFragment {

    private DiaryViewModel diaryViewModel;
    FragmentDiaryBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDiaryBinding.inflate(getLayoutInflater());
        diaryViewModel = getViewModel(DiaryViewModel.class);




        return binding.getRoot();
    }
}