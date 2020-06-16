package com.example.nutrimeter.data.model.room;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.nutrimeter.data.model.room.entity.MealEntity;
import com.example.nutrimeter.data.model.room.entity.ProgressEntry;

import java.util.List;

public class ProgressWithMealsAndFoods {
    @Embedded
    public ProgressEntry progressEntry;
    @Relation(
            entity = MealEntity.class,
            parentColumn = ProgressEntry.PRIMARY_KEY_ID,
            entityColumn = MealEntity.PROGRESS_ID
    )
    public List<MealWithFoods> mealsWithFoods;
}
