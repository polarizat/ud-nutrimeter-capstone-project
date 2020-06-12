package com.example.nutrimeter.data.model;

import java.sql.Date;

public class Meal {

    private int id;

    private SearchResultFood[] foods;
    private Date date;

    private int total_kcal;
    private int total_proteins;
    private int total_carbs;
    private int total_fats;

    public Meal(int id, SearchResultFood[] foods, Date date, int total_kcal, int total_proteins, int total_carbs, int total_fats) {
        this.id = id;
        this.foods = foods;
        this.date = date;
        this.total_kcal = total_kcal;
        this.total_proteins = total_proteins;
        this.total_carbs = total_carbs;
        this.total_fats = total_fats;
    }

    public int getId() {
        return id;
    }

    public SearchResultFood[] getFoods() {
        return foods;
    }

    public Date getDate() {
        return date;
    }

    public int getTotal_kcal() {
        return total_kcal;
    }

    public int getTotal_proteins() {
        return total_proteins;
    }

    public int getTotal_carbs() {
        return total_carbs;
    }

    public int getTotal_fats() {
        return total_fats;
    }
}
