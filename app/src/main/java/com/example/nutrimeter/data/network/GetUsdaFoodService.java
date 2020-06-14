package com.example.nutrimeter.data.network;

import com.example.nutrimeter.BuildConfig;
import com.example.nutrimeter.data.model.search.SearchResult;
import com.example.nutrimeter.util.UsdaUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetUsdaFoodService {


    /**
     * /fdc/v1/food/167765
     * ?format=abridged
     * &nutrients=203&nutrients=204&nutrients=205
     * */
    @GET("fdc/v1/food{fcdId}?api_key=" + BuildConfig.USDA_API_KEY)
    Call<SearchResult> getFoodItemById(
        @Path(UsdaUtils.USDA_FOOD_PATH_FDC_ID) int fcdId,
        @Query(UsdaUtils.USDA_FOOD_QUERY_FIELD_FORMAT) String format
    );

    @GET("fdc/v1/food{fcdId}?api_key=" + BuildConfig.USDA_API_KEY)
    Call<SearchResult> getFoodWithSpecificNutrients(
        @Path(UsdaUtils.USDA_FOOD_PATH_FDC_ID) int fcdId,
        @Query(UsdaUtils.USDA_FOOD_QUERY_FIELD_FORMAT) String format,
        @Query(UsdaUtils.USDA_FOOD_QUERY_FIELD_NUTRIENTS) List<String> nutrients
    );

    /**
     * /fdc/v1/foods/search
     * ?query=cheddar%20cheese
     * &dataType=Foundation,SR%20Legacy
     * &pageSize=25
     * &pageNumber=2
     * &sortBy=description
     * &sortOrder=asc&brand
     * Owner=Kar%20Nut%20Products%20Company
     * */

    @GET("fdc/v1/foods/search?api_key=" + BuildConfig.USDA_API_KEY)
    Call<SearchResult> getSearchFoodList(
            @Query(UsdaUtils.USDA_SEARCH_QUERY_FIELD) String query
    );

    @GET("fdc/v1/foods/search?api_key=" + BuildConfig.USDA_API_KEY)
    Call<SearchResult> getSearchFoodList(
            @Query(UsdaUtils.USDA_SEARCH_QUERY_FIELD) String query,
            @Query(UsdaUtils.USDA_SEARCH_QUERY_FIELD_DATA_TYPE) List<String> dataType
    );

    @GET("fdc/v1/foods/search?api_key=" + BuildConfig.USDA_API_KEY)
    Call<SearchResult> getSearchFoodList(
        @Query(UsdaUtils.USDA_SEARCH_QUERY_FIELD) String query,
        @Query(UsdaUtils.USDA_SEARCH_QUERY_FIELD_DATA_TYPE) List<String> dataType,
        @Query(UsdaUtils.USDA_SEARCH_QUERY_FIELD_PAGE_SIZE) int pageSize,
        @Query(UsdaUtils.USDA_SEARCH_QUERY_FIELD_PAGE_NUMBER) int pageNumber
    );


}