package com.example.nutrimeter.data.model.usda.foundation;

public class MeasureUnit {

    public static final String MEASURE_UNIT_ID = "id";
    public static final String MEASURE_UNIT_ABBREVIATION = "abbreviation";
    public static final String MEASURE_UNIT_NAME = "name";

    private int id;
    private String abbreviation;
    private String name;

    public MeasureUnit(int id, String abbreviation, String name) {
        this.id = id;
        this.abbreviation = abbreviation;
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }
}
