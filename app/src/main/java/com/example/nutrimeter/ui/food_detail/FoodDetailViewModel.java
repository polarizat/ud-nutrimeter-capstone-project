package com.example.nutrimeter.ui.food_detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nutrimeter.data.model.Food;
import com.example.nutrimeter.data.repo.UsdaRepo;

import javax.inject.Inject;

import timber.log.Timber;

public class FoodDetailViewModel extends ViewModel {

    UsdaRepo mUsdaRepo;
    MutableLiveData<Float> mQuantityLiveData;

    @Inject
    public FoodDetailViewModel(UsdaRepo usdaRepo){
        mUsdaRepo = usdaRepo;
        mQuantityLiveData = new MutableLiveData<>();
    }

    public LiveData<Food> getSelectedFood(){
        Timber.d("(polarizat) ---> FoodDetailViewModel ----> getSelectedFood: ");
        return mUsdaRepo.getSelectedFood();
    }

    public MutableLiveData<Float> getmQuantityLiveData() {
        return mQuantityLiveData;
    }

    public void updateQuantity(float mQuantityLiveData) {
        this.mQuantityLiveData.setValue(mQuantityLiveData);
    }
}
