package com.example.nutrimeter.data.model.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = ProgressEntry.TABLE_NAME)
public class ProgressEntry {

    public static final String TABLE_NAME = "progress_entries";
    public static final String PRIMARY_KEY_ID = "id";

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int userId;
    private String date;

    private int kcalEaten;
    private int kcalBurned;
    private int kcalLeft;
    private int proteinsEaten;
    private int fatsEaten;
    private int carbsEaten;

    private String status;

    private float currentWeight;
    private float currentGoalWeight;

    public ProgressEntry(int id, int userId, String date, int kcalEaten, int kcalBurned, int kcalLeft, int proteinsEaten, int fatsEaten, int carbsEaten, String status, float currentWeight, float currentGoalWeight) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.kcalEaten = kcalEaten;
        this.kcalBurned = kcalBurned;
        this.kcalLeft = kcalLeft;
        this.proteinsEaten = proteinsEaten;
        this.fatsEaten = fatsEaten;
        this.carbsEaten = carbsEaten;
        this.status = status;
        this.currentWeight = currentWeight;
        this.currentGoalWeight = currentGoalWeight;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getPrimaryKeyId() {
        return PRIMARY_KEY_ID;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getDate() {
        return date;
    }

    public int getKcalEaten() {
        return kcalEaten;
    }

    public int getKcalBurned() {
        return kcalBurned;
    }

    public int getKcalLeft() {
        return kcalLeft;
    }

    public int getProteinsEaten() {
        return proteinsEaten;
    }

    public int getFatsEaten() {
        return fatsEaten;
    }

    public int getCarbsEaten() {
        return carbsEaten;
    }

    public String getStatus() {
        return status;
    }

    public float getCurrentWeight() {
        return currentWeight;
    }

    public float getCurrentGoalWeight() {
        return currentGoalWeight;
    }
}
