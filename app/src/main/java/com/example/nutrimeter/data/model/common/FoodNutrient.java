package com.example.nutrimeter.data.model.common;

public class FoodNutrient {

    public static final String FOOD_NUTRIENT_FIELD_ID = "id";
    public static final String FOOD_NUTRIENT_FIELD_AMOUNT = "amount";
    public static final String FOOD_NUTRIENT_FIELD_DATA_POINTS = "dataPoints";
    public static final String FOOD_NUTRIENT_FIELD_MIN = "min";
    public static final String FOOD_NUTRIENT_FIELD_MAX = "max";
    public static final String FOOD_NUTRIENT_FIELD_MEDIAN = "median";
    public static final String FOOD_NUTRIENT_FIELD_TYPE = "type";
    public static final String FOOD_NUTRIENT_FIELD_NUTRIENT = "nutrient";
    public static final String FOOD_NUTRIENT_FIELD_FOOD_NUTRIENT_DESCRIPTION = "foodNutrientDerivation";
    public static final String FOOD_NUTRIENT_FIELD_NUTRIENT_ANALYSIS_DETAILS = "nutrientAnalysisDetails";

    private int id;
    private float amount;
    private int dataPoints;
    private float min;
    private float max;
    private float median;
    private String type;

    private Nutrient nutrient;
    private FoodNutrientDerivation foodNutrientDerivation;
    private NutrientAnalysisDetails nutrientAnalysisDetails;

    public FoodNutrient(int id, float amount, int dataPoints, float min, float max, float median, String type, Nutrient nutrient, FoodNutrientDerivation foodNutrientDerivation, NutrientAnalysisDetails nutrientAnalysisDetails) {
        this.id = id;
        this.amount = amount;
        this.dataPoints = dataPoints;
        this.min = min;
        this.max = max;
        this.median = median;
        this.type = type;
        this.nutrient = nutrient;
        this.foodNutrientDerivation = foodNutrientDerivation;
        this.nutrientAnalysisDetails = nutrientAnalysisDetails;
    }

    public int getId() {
        return id;
    }

    public float getAmount() {
        return amount;
    }

    public int getDataPoints() {
        return dataPoints;
    }

    public float getMin() {
        return min;
    }

    public float getMax() {
        return max;
    }

    public float getMedian() {
        return median;
    }

    public String getType() {
        return type;
    }

    public Nutrient getNutrient() {
        return nutrient;
    }

    public FoodNutrientDerivation getFoodNutrientDerivation() {
        return foodNutrientDerivation;
    }

    public NutrientAnalysisDetails getNutrientAnalysisDetails() {
        return nutrientAnalysisDetails;
    }
}
