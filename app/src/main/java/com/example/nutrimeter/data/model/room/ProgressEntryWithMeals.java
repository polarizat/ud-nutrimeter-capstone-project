package com.example.nutrimeter.data.model.room;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.nutrimeter.data.model.room.entity.Meal;
import com.example.nutrimeter.data.model.room.entity.ProgressEntry;

import java.util.List;

public class ProgressEntryWithMeals {

    @Embedded
    public ProgressEntry progressEntry;
    @Relation(
            parentColumn = ProgressEntry.PRIMARY_KEY_ID,
            entityColumn = Meal.TABLE_PRIMARY_KEY,
            associateBy = @Junction(ProgressEntryMealCrossRef.class)
    )
    public List<Meal> meals;

}
