package com.example.nutrimeter.data.model.search;

import java.util.ArrayList;

public class AbridgedFoodItem {

    // *Mandatory
    private String dataType;
    private String description;
    private int fdcId;


    private ArrayList<AbridgedFoodNutrient> foodNutrients;
    private String publicationDate;

    private String ndbNumber;

    private String brandOwner;
    private String gtinUpc;

    private String foodCode;

    public AbridgedFoodItem(String dataType, String description, int fdcId, ArrayList<AbridgedFoodNutrient> foodNutrients, String publicationDate, String ndbNumber, String brandOwner, String gtinUpc, String foodCode) {
        this.dataType = dataType;
        this.description = description;
        this.fdcId = fdcId;
        this.foodNutrients = foodNutrients;
        this.publicationDate = publicationDate;
        this.ndbNumber = ndbNumber;
        this.brandOwner = brandOwner;
        this.gtinUpc = gtinUpc;
        this.foodCode = foodCode;
    }

    public String getDataType() {
        return dataType;
    }

    public String getDescription() {
        return description;
    }

    public int getFdcId() {
        return fdcId;
    }

    public ArrayList<AbridgedFoodNutrient> getFoodNutrients() {
        return foodNutrients;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getNdbNumber() {
        return ndbNumber;
    }

    public String getBrandOwner() {
        return brandOwner;
    }

    public String getGtinUpc() {
        return gtinUpc;
    }

    public String getFoodCode() {
        return foodCode;
    }
}
