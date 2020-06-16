package com.example.nutrimeter.data.model.usda.common;

public class FoodCategory {

    public static final String FOOD_CATEGORY_FIELD_ID = "id";
    public static final String FOOD_CATEGORY_FIELD_CODE = "code";
    public static final String FOOD_CATEGORY_FIELD_DESCRIPTION = "description";

    private int id;
    private String code;
    private String description;

    public FoodCategory(int id, String code, String description) {
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
