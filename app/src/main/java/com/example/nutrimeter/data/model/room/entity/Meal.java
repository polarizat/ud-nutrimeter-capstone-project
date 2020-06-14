package com.example.nutrimeter.data.model.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Meal.TABLE_NAME)
public class Meal {

    public static final String TABLE_NAME = "meals";
    public static final String TABLE_PRIMARY_KEY = "mealId";
    public static final String PROGRESS_ID = "progressEntryId";

    @PrimaryKey(autoGenerate = true)
    private int mealId;
    private int userId;
    private int progressEntryId;

    private String date;

    private int total_kcal;
    private int total_proteins;
    private int total_carbs;
    private int total_fats;

    public Meal(int userId, int progressEntryId, String date, int total_kcal, int total_proteins, int total_carbs, int total_fats) {
        this.userId = userId;
        this.progressEntryId = progressEntryId;
        this.date = date;
        this.total_kcal = total_kcal;
        this.total_proteins = total_proteins;
        this.total_carbs = total_carbs;
        this.total_fats = total_fats;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProgressEntryId() {
        return progressEntryId;
    }

    public void setProgressEntryId(int progressEntryId) {
        this.progressEntryId = progressEntryId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotal_kcal() {
        return total_kcal;
    }

    public void setTotal_kcal(int total_kcal) {
        this.total_kcal = total_kcal;
    }

    public int getTotal_proteins() {
        return total_proteins;
    }

    public void setTotal_proteins(int total_proteins) {
        this.total_proteins = total_proteins;
    }

    public int getTotal_carbs() {
        return total_carbs;
    }

    public void setTotal_carbs(int total_carbs) {
        this.total_carbs = total_carbs;
    }

    public int getTotal_fats() {
        return total_fats;
    }

    public void setTotal_fats(int total_fats) {
        this.total_fats = total_fats;
    }
}
