package com.example.nutrimeter.data.model.search;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {

    private int totalHits;
    private int currentPage;
    private int totalPages;

    private ArrayList<SearchResultFood> foods;

    private FoodSearchCriteria foodSearchCriteria;

    public SearchResult(int totalHits, int currentPage, int totalPages, ArrayList<SearchResultFood> foods, FoodSearchCriteria foodSearchCriteria) {
        this.totalHits = totalHits;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.foods = foods;
        this.foodSearchCriteria = foodSearchCriteria;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<SearchResultFood> getFoods() {
        return foods;
    }

    public FoodSearchCriteria getFoodSearchCriteria() {
        return foodSearchCriteria;
    }
}
