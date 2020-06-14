package com.example.nutrimeter.ui.search_food;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.nutrimeter.common.Resource;
import com.example.nutrimeter.data.model.search.SearchResultFood;
import com.example.nutrimeter.data.repo.UsdaRepo;
import com.example.nutrimeter.util.UsdaUtils;

import java.util.List;

import javax.inject.Inject;

public class SearchUsdaViewModel extends ViewModel {

    private UsdaRepo usdaRepo;

    private LiveData<Resource<List<SearchResultFood>>> searchedFoodListLiveData;

    @Inject
    public SearchUsdaViewModel(UsdaRepo usdaRepo){
        this.usdaRepo = usdaRepo;
        searchedFoodListLiveData = usdaRepo.getSearchedFoodListLiveData();
    }

    public LiveData<Resource<List<SearchResultFood>>> getSearchedFoodListLiveData() {
        return searchedFoodListLiveData;
    }


    public void performSearch(String query) {
        usdaRepo.fetchSearchedFoodList(
                query,
                UsdaUtils.getListOfDataTypes(
                        UsdaUtils.SearchDataType.SR_LEGACY),
                25, 2);
    }
}