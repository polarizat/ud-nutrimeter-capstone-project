package com.example.nutrimeter.ui.diary;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;
import javax.inject.Singleton;

import timber.log.Timber;

public class DiaryViewModel extends ViewModel {

    private MutableLiveData<String> mText;


    @Inject
    public DiaryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Diary fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }


}