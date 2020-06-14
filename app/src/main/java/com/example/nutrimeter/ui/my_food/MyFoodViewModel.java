package com.example.nutrimeter.ui.my_food;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class MyFoodViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    @Inject
    public MyFoodViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}