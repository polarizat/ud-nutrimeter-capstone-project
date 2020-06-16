package com.example.nutrimeter.data.model.room;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.nutrimeter.data.model.room.entity.MealEntity;
import com.example.nutrimeter.data.model.room.entity.ProgressEntry;

import java.util.List;

public class ProgressEntryWithMeals {

    @Embedded
    public ProgressEntry progressEntry;
    @Relation(
            parentColumn = ProgressEntry.PRIMARY_KEY_ID,
            entityColumn = MealEntity.TABLE_PRIMARY_KEY,
            associateBy = @Junction(ProgressEntryMealCrossRef.class)
    )
    public List<MealEntity> mealEntities;

}
