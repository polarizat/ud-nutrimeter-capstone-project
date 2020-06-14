package com.example.nutrimeter.data.model.room;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.nutrimeter.data.model.room.entity.Meal;
import com.example.nutrimeter.data.model.room.entity.ProgressEntry;

import java.util.List;

public class ProgressWithMealsAndFoods {
    @Embedded
    public ProgressEntry progressEntry;
    @Relation(
            entity = Meal.class,
            parentColumn = ProgressEntry.PRIMARY_KEY_ID,
            entityColumn = Meal.PROGRESS_ID
    )
    public List<MealWithFoods> mealsWithFoods;
}
