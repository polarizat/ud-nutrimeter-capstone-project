package com.example.nutrimeter.data.model.room;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.nutrimeter.data.model.room.entity.FoodEntity;
import com.example.nutrimeter.data.model.room.entity.MealEntity;

import java.util.List;

public class MealWithFoods {

    @Embedded
    public MealEntity mealEntity;
    @Relation(
            parentColumn = MealEntity.TABLE_PRIMARY_KEY,
            entityColumn = FoodEntity.PRIMARY_KEY_ID,
            associateBy = @Junction(MealFoodCrossRef.class)
    )
    public List<FoodEntity> foodEntities;


}
