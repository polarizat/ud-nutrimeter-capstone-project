package com.example.nutrimeter.data.model.room;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.nutrimeter.data.model.room.entity.Food;
import com.example.nutrimeter.data.model.room.entity.Meal;

import java.util.List;

public class MealWithFoods {

    @Embedded
    public Meal meal;
    @Relation(
            parentColumn = Meal.TABLE_PRIMARY_KEY,
            entityColumn = Food.PRIMARY_KEY_ID,
            associateBy = @Junction(MealFoodCrossRef.class)
    )
    public List<Food> foods;


}
