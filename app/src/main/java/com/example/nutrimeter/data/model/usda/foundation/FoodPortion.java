package com.example.nutrimeter.data.model.usda.foundation;


public class FoodPortion {

    private static final String FOOD_PORTION_FIELD_ID = "id";
    private static final String FOOD_PORTION_FIELD_AMOUNT = "amount";
    private static final String FOOD_PORTION_FIELD_DATA_POINTS = "dataPoints";
    private static final String FOOD_PORTION_FIELD_GRAM_WEIGHT = "gramWeight";
    private static final String FOOD_PORTION_FIELD_MIN_YEAR_ACQUIRED = "minYearAcquired";
    private static final String FOOD_PORTION_FIELD_MODIFIER = "modifier";
    private static final String FOOD_PORTION_FIELD_PORTION_DESCRIPTION = "portionDescription";
    private static final String FOOD_PORTION_FIELD_SEQUENCE_NUMBER = "sequenceNumber";
    private static final String FOOD_PORTION_FIELD_MEASURE_UNIT = "measureUnit";

    private int id;
    private float amount;
    private int dataPoints;
    private float gramWeight;
    private int minYearAcquired;
    private String modifier;
    private String portionDescription;
    private int sequenceNumber;
    private MeasureUnit measureUnit;

    public FoodPortion(int id, float amount, int dataPoints, float gramWeight, int minYearAcquired, String modifier, String portionDescription, int sequenceNumber, MeasureUnit measureUnit) {
        this.id = id;
        this.amount = amount;
        this.dataPoints = dataPoints;
        this.gramWeight = gramWeight;
        this.minYearAcquired = minYearAcquired;
        this.modifier = modifier;
        this.portionDescription = portionDescription;
        this.sequenceNumber = sequenceNumber;
        this.measureUnit = measureUnit;
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

    public float getGramWeight() {
        return gramWeight;
    }

    public int getMinYearAcquired() {
        return minYearAcquired;
    }

    public String getModifier() {
        return modifier;
    }

    public String getPortionDescription() {
        return portionDescription;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public MeasureUnit getMeasureUnit() {
        return measureUnit;
    }
}
