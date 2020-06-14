package com.example.nutrimeter.data.model.common;

public class FoodNutrientDerivation {

    public static final String FOOD_NUTRIENT_DERIVATION_FIELD_ID = "id";
    public static final String FOOD_NUTRIENT_DERIVATION_FIELD_CODE = "code";
    public static final String FOOD_NUTRIENT_DERIVATION_FIELD_DESCRIPTION = "description";
    public static final String FOOD_NUTRIENT_DERIVATION_FIELD_FOOD_NUTRIENT_SOURCE = "foodNutrientSource";

    private int id;
    private String code;
    private String description;
    private FoodNutrientSource foodNutrientSource;

    public FoodNutrientDerivation(int id, String code, String description, FoodNutrientSource foodNutrientSource) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.foodNutrientSource = foodNutrientSource;
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

    public FoodNutrientSource getFoodNutrientSource() {
        return foodNutrientSource;
    }
}
