package com.example.nutrimeter.data.model.usda.search;

import java.util.List;

public class FoodSearchCriteria {

    private String query;
    private List<String> dataType;
    private int pageSize;
    private int pageNumber;
    private int sortBy;
    private String sortOrder;
    private String brandOwner;

    public FoodSearchCriteria(){

    }

    public FoodSearchCriteria(String query, List<String> dataType, int pageSize, int pageNumber, int sortBy, String sortOrder, String brandOwner) {
        this.query = query;
        this.dataType = dataType;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.sortBy = sortBy;
        this.sortOrder = sortOrder;
        this.brandOwner = brandOwner;
    }

    public String getQuery() {
        return query;
    }

    public List<String> getDataType() {
        return dataType;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getSortBy() {
        return sortBy;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public String getBrandOwner() {
        return brandOwner;
    }

    @Override
    public String toString() {
        return "FoodSearchCriteria{" +
                "query='" + query + '\'' +
                ", pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                ", sortBy=" + sortBy +
                ", sortOrder='" + sortOrder + '\'' +
                ", brandOwner='" + brandOwner + '\'' +
                '}';
    }
}
