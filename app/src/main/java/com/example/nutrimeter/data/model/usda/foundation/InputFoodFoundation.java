package com.example.nutrimeter.data.model.usda.foundation;

public class InputFoodFoundation {

    public static final String INPUT_FOOD_FOUNDATION_FIELD_ID = "id";
    public static final String INPUT_FOOD_FOUNDATION_FIELD_FOOD_DESCRIPTION = "foodDescription";
    public static final String INPUT_FOOD_FOUNDATION_FIELD_INPUT_FOOD = "inputFood";

    private int id;
    private String foodDescription;
    private SampleFoodItem inputFood;

    public InputFoodFoundation(int id, String foodDescription, SampleFoodItem inputFood) {
        this.id = id;
        this.foodDescription = foodDescription;
        this.inputFood = inputFood;
    }

    public int getId() {
        return id;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public SampleFoodItem getInputFood() {
        return inputFood;
    }
}
