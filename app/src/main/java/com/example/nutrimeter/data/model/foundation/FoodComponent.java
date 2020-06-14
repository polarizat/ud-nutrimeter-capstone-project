package com.example.nutrimeter.data.model.foundation;

public class FoodComponent {

    public static final String FOOD_COMPONENT_FIELD_ID = "id";
    public static final String FOOD_COMPONENT_FIELD_NAME = "name";
    public static final String FOOD_COMPONENT_FIELD_DATA_POINTS = "dataPoints";
    public static final String FOOD_COMPONENT_FIELD_GRAM_WEIGHT = "gramWeight";
    public static final String FOOD_COMPONENT_FIELD_IS_REFUSE = "isRefuse";
    public static final String FOOD_COMPONENT_FIELD_MIN_YEAR_ACQUIRED = "minYearAcquired";
    public static final String FOOD_COMPONENT_FIELD_PERCENT_WEIGHT = "percentWeight";

    private int id;
    private String name;
    private int dataPoints;
    private int gramWeight;
    private boolean isRefuse;
    private int minYearAcquired;
    private float percentWeight;

    public FoodComponent(int id, String name, int dataPoints, int gramWeight, boolean isRefuse, int minYearAcquired, float percentWeight) {
        this.id = id;
        this.name = name;
        this.dataPoints = dataPoints;
        this.gramWeight = gramWeight;
        this.isRefuse = isRefuse;
        this.minYearAcquired = minYearAcquired;
        this.percentWeight = percentWeight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDataPoints() {
        return dataPoints;
    }

    public int getGramWeight() {
        return gramWeight;
    }

    public boolean isRefuse() {
        return isRefuse;
    }

    public int getMinYearAcquired() {
        return minYearAcquired;
    }

    public float getPercentWeight() {
        return percentWeight;
    }
}
