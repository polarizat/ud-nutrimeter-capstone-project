package com.example.nutrimeter.data.model.common;

public class FoodNutrientSource {

    public static final String FOOD_NUTRIENT_SOURCE_FIELD_ID = "id";
    public static final String FOOD_NUTRIENT_SOURCE_FIELD_CODE = "code";
    public static final String FOOD_NUTRIENT_SOURCE_FIELD_DESCRIPTION = "description";

    private int id;
    private String code;
    private String description;

    public FoodNutrientSource(int id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
