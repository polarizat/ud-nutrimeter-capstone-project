package com.example.nutrimeter.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.nutrimeter.data.model.room.MealFoodCrossRef;
import com.example.nutrimeter.data.model.room.ProgressEntryMealCrossRef;
import com.example.nutrimeter.data.model.room.entity.FoodEntity;
import com.example.nutrimeter.data.model.room.entity.MealEntity;
import com.example.nutrimeter.data.model.room.entity.ProgressEntry;
import com.example.nutrimeter.data.model.room.entity.UserEntity;

@Database(
        entities = {
            FoodEntity.class,
            MealEntity.class,
            UserEntity.class,
            ProgressEntry.class,
            MealFoodCrossRef.class,
            ProgressEntryMealCrossRef.class},
        version = 1,
        exportSchema = false)

public abstract class NutriMeterRoomDatabase extends RoomDatabase {
    public abstract FoodsDao foodsDao();

}

