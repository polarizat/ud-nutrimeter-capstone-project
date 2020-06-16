package com.example.nutrimeter.data.model;

import com.example.nutrimeter.data.model.usda.search.AbridgedFoodNutrient;
import com.example.nutrimeter.util.UsdaUtils;

import timber.log.Timber;

public class Nutrient {

    private int categoryNumber;

    private int nutrientId;
    private String nutrientName;
    private int nutrientNumber;
    private String unitName;
    private float value;

    private String derivationCode;
    private String derivationDescription;


    public Nutrient(AbridgedFoodNutrient abridgedFoodNutrient){
        Timber.d("(polarizat) ---> Nutrient ----> Nutrient: " + abridgedFoodNutrient.getNutrientNumber() + "  " + abridgedFoodNutrient.getNutrientName());
        this.categoryNumber = UsdaUtils.getNutrientCategoryNumber(abridgedFoodNutrient.getNutrientNumber());

        this.nutrientId = abridgedFoodNutrient.getNutrientId();
        this.nutrientName = abridgedFoodNutrient.getNutrientName();
        this.nutrientNumber = abridgedFoodNutrient.getNutrientNumber();
        this.unitName = abridgedFoodNutrient.getUnitName();
        this.value = abridgedFoodNutrient.getValue();

        this.derivationCode = abridgedFoodNutrient.getDerivationCode();
        this.derivationDescription = abridgedFoodNutrient.getDerivationDescription();
    }

    public int getCategoryNumber() {
        return categoryNumber;
    }

    public int getNutrientId() {
        return nutrientId;
    }

    public String getNutrientName() {
        return nutrientName;
    }

    public int getNutrientNumber() {
        return nutrientNumber;
    }

    public String getUnitName() {
        return unitName;
    }

    public float getValue() {
        return value;
    }

    public String getDerivationCode() {
        return derivationCode;
    }

    public String getDerivationDescription() {
        return derivationDescription;
    }
}
