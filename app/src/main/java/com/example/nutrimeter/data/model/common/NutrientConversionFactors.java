package com.example.nutrimeter.data.model.common;

public class NutrientConversionFactors {

    public static final String NUTRIENT_CONVERSION_FACTORS_FIELD_TYPE = "type";
    public static final String NUTRIENT_CONVERSION_FACTORS_FIELD_VALUE = "value";

    private String type;
    private float value;

    public NutrientConversionFactors(String type, float value) {
        this.type = type;
        this.value = value;
    }

    public static String getNutrientConversionFactorsFieldType() {
        return NUTRIENT_CONVERSION_FACTORS_FIELD_TYPE;
    }

    public static String getNutrientConversionFactorsFieldValue() {
        return NUTRIENT_CONVERSION_FACTORS_FIELD_VALUE;
    }

    public String getType() {
        return type;
    }

    public float getValue() {
        return value;
    }
}
