package com.example.nutrimeter.data.model.common;

public class Nutrient {

    public static final String NUTRIENT_FIELD_ID = "id";
    public static final String NUTRIENT_FIELD_NUMBER = "number";
    public static final String NUTRIENT_FIELD_NAME = "name";
    public static final String NUTRIENT_FIELD_RANK = "rank";
    public static final String NUTRIENT_FIELD_UNIT_NAME = "unitName";

    private int id;
    private String number;
    private String name;
    private int rank;
    private String unitName;

    public Nutrient(int id, String number, String name, int rank, String unitName) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.rank = rank;
        this.unitName = unitName;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public String getUnitName() {
        return unitName;
    }
}

