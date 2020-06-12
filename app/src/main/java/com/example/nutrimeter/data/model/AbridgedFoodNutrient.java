package com.example.nutrimeter.data.model;

public class AbridgedFoodNutrient {

    private int number;
    private String name;
    private float amount;
    private String unitName;
    private String derivationCode;
    private String derivationDescription;

    public AbridgedFoodNutrient(int number, String name, float amount, String unitName, String derivationCode, String derivationDescription) {
        this.number = number;
        this.name = name;
        this.amount = amount;
        this.unitName = unitName;
        this.derivationCode = derivationCode;
        this.derivationDescription = derivationDescription;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public float getAmount() {
        return amount;
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
}
