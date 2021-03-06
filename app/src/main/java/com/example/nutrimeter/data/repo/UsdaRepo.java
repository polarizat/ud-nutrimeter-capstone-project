package com.example.nutrimeter.data.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.nutrimeter.common.Resource;
import com.example.nutrimeter.data.model.Food;
import com.example.nutrimeter.data.model.usda.search.SearchResult;
import com.example.nutrimeter.data.model.usda.search.SearchResultFood;
import com.example.nutrimeter.data.network.GetUsdaFoodService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import timber.log.Timber;

public class UsdaRepo {

    Retrofit mRetrofit;

    MutableLiveData<Resource<List<SearchResultFood>>> searchedFoodListLiveData;
    MutableLiveData<Food> selectedFood;

    @Inject
    public UsdaRepo(Retrofit retrofit){
        mRetrofit = retrofit;
        searchedFoodListLiveData = new MutableLiveData<>();
        selectedFood = new MutableLiveData<>();
    }

    public MutableLiveData<Resource<List<SearchResultFood>>> getSearchedFoodListLiveData() {
        return searchedFoodListLiveData;
    }

    /*** Gets the USDA SearchResultFood list by query*/
    public void fetchSearchedFoodList(String query, List<String> dataTypes, int pageSize, int pageNumber) {
        GetUsdaFoodService service = mRetrofit.create(GetUsdaFoodService.class);
        searchedFoodListLiveData.setValue(new Resource<>(Resource.Status.LOADING, null, "Loading"));

        Call<SearchResult> call =
                service.getSearchFoodList(query, dataTypes, pageSize, pageNumber);

        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {

                SearchResult searchResult = response.body();
                Timber.d("(polarizat) ---> UsdaRepo ----> onResponse: URL %s", call.request().url().toString());
                Timber.d("(polarizat) ---> UsdaRepo ----> onResponse: THE MESSAGE IS %s", response.message());
                searchedFoodListLiveData.setValue(new Resource<>(Resource.Status.SUCCESS, searchResult.getFoods(), response.message()));
            }
            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                searchedFoodListLiveData.setValue(new Resource<>(Resource.Status.ERROR, null, t.getLocalizedMessage()));
                Timber.e("onFailure: on Failure%s", t.getLocalizedMessage());
            }
        }) ;

    }


    public void setSelectedFood(Food food) {
        if (selectedFood == null){
            selectedFood = new MutableLiveData<>();
        }
        selectedFood.setValue(food);
    }

    public LiveData<Food> getSelectedFood() {
        return selectedFood;
    }
}
