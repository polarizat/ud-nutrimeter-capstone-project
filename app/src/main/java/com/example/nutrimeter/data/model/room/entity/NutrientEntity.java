package com.example.nutrimeter.data.model.room.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.nutrimeter.data.model.usda.search.AbridgedFoodNutrient;

@Entity(tableName = NutrientEntity.TABLE_NAME)
public class NutrientEntity {

    public static final String TABLE_NAME = "nutrients";
    public static final String PRIMARY_KEY_ID = "id";

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int nmFoodId;

    private int nutrientId;
    private String nutrientName;
    private int nutrientNumber;
    private String unitName;
    private float value;

    public NutrientEntity(int nmFoodId, int nutrientId, String nutrientName, int nutrientNumber, String unitName, float value) {
        this.nmFoodId = nmFoodId;
        this.nutrientId = nutrientId;
        this.nutrientName = nutrientName;
        this.nutrientNumber = nutrientNumber;
        this.unitName = unitName;
        this.value = value;
    }

    @Ignore
    public NutrientEntity(int nmFoodId, AbridgedFoodNutrient abridgedFoodNutrient){
        this.nmFoodId = nmFoodId;

        this.nutrientId = abridgedFoodNutrient.getNutrientId();
        this.nutrientName = abridgedFoodNutrient.getNutrientName();
        this.nutrientNumber = abridgedFoodNutrient.getNutrientNumber();
        this.unitName = abridgedFoodNutrient.getUnitName();
        this.value = abridgedFoodNutrient.getValue();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNmFoodId() {
        return nmFoodId;
    }

    public void setNmFoodId(int nmFoodId) {
        this.nmFoodId = nmFoodId;
    }

    public int getNutrientId() {
        return nutrientId;
    }

    public void setNutrientId(int nutrientId) {
        this.nutrientId = nutrientId;
    }

    public String getNutrientName() {
        return nutrientName;
    }

    public void setNutrientName(String nutrientName) {
        this.nutrientName = nutrientName;
    }

    public int getNutrientNumber() {
        return nutrientNumber;
    }

    public void setNutrientNumber(int nutrientNumber) {
        this.nutrientNumber = nutrientNumber;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
