package com.example.nutrimeter.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.nutrimeter.data.model.room.MealFoodCrossRef;
import com.example.nutrimeter.data.model.room.ProgressEntryMealCrossRef;
import com.example.nutrimeter.data.model.room.entity.Food;
import com.example.nutrimeter.data.model.room.entity.Meal;
import com.example.nutrimeter.data.model.room.entity.ProgressEntry;
import com.example.nutrimeter.data.model.room.entity.User;

@Database(
        entities = {
            Food.class,
            Meal.class,
            User.class,
            ProgressEntry.class,
            MealFoodCrossRef.class,
            ProgressEntryMealCrossRef.class},
        version = 1,
        exportSchema = false)

public abstract class NutriMeterRoomDatabase extends RoomDatabase {
    public abstract FoodsDao foodsDao();

}

