package com.example.nutrimeter.nutritioncalculatorjava;

public class NutritionCalculator {

    public static float getMetricHeight(float feet, float inches){
        return ((feet * 30.48f) + (inches * 2.54f));
    }

    public static float getMetricWeight(float lbs) {
        return (lbs * 0.45359f);
    }
}