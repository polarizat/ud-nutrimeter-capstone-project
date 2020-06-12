package com.example.nutrimeter.data.network;

import com.example.nutrimeter.data.model.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/fdc/v1/")
    Call<SearchResult> getSearchResult();
}