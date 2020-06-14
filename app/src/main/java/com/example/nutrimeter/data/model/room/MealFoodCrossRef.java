package com.example.nutrimeter.data.model.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;

@Entity(primaryKeys = {"mealId", "foodId"}, indices = {@Index("foodId")})
public class MealFoodCrossRef {

    public int mealId;
    @ColumnInfo(name = "foodId")
    public int foodId;

    public MealFoodCrossRef(int mealId, int foodId) {
        this.mealId = mealId;
        this.foodId = foodId;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
}
