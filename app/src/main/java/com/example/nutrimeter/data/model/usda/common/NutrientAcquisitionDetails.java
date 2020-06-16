package com.example.nutrimeter.data.model.usda.common;

public class NutrientAcquisitionDetails {

    public static final String NUTRIENT_ACQUISITION_DETAILS_FIELD_SAMPLE_UNIT_ID = "sampleUnitId";
    public static final String NUTRIENT_ACQUISITION_DETAILS_FIELD_PURCHASE_DATE = "purchaseDate";
    public static final String NUTRIENT_ACQUISITION_DETAILS_FIELD_STORE_CITY = "storeCity";
    public static final String NUTRIENT_ACQUISITION_DETAILS_FIELD_STORE_STATE = "storeState";

    private int sampleUnitId;
    private String purchaseDate;
    private String storeCity;
    private String storeState;

    public NutrientAcquisitionDetails(int sampleUnitId, String purchaseDate, String storeCity, String storeState) {
        this.sampleUnitId = sampleUnitId;
        this.purchaseDate = purchaseDate;
        this.storeCity = storeCity;
        this.storeState = storeState;
    }

    public int getSampleUnitId() {
        return sampleUnitId;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public String getStoreCity() {
        return storeCity;
    }

    public String getStoreState() {
        return storeState;
    }
}
