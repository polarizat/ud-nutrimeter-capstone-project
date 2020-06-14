package com.example.nutrimeter.data.model.search;

public class AbridgedFoodNutrient {

    private int nutrientId;
    private String nutrientName;
    private int nutrientNumber;
    private String unitName;
    private String derivationCode;
    private String derivationDescription;
    private float value;

    public AbridgedFoodNutrient(int nutrientId, String nutrientName, int nutrientNumber, String unitName, String derivationCode, String derivationDescription, float value) {
        this.nutrientId = nutrientId;
        this.nutrientName = nutrientName;
        this.nutrientNumber = nutrientNumber;
        this.unitName = unitName;
        this.derivationCode = derivationCode;
        this.derivationDescription = derivationDescription;
        this.value = value;
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

    public String getDerivationCode() {
        return derivationCode;
    }

    public String getDerivationDescription() {
        return derivationDescription;
    }

    public float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "AbridgedFoodNutrient{" +
                "nutrientId=" + nutrientId +
                ", nutrientName='" + nutrientName + '\n' +
                ", nutrientNumber=" + nutrientNumber +
                ", unitName='" + unitName + '\n' +
                ", derivationCode='" + derivationCode + '\n' +
                ", derivationDescription='" + derivationDescription + '\n' +
                ", value=" + value +
                '}';
    }
}
