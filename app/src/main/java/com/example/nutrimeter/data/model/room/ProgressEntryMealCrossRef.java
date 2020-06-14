package com.example.nutrimeter.data.model.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;

@Entity(primaryKeys = {"id", "mealId"}, indices = {@Index("mealId")})
public class ProgressEntryMealCrossRef {

    public int id;
    @ColumnInfo(name = "mealId")
    public int mealId;

    public ProgressEntryMealCrossRef(int id, int mealId) {
        this.id = id;
        this.mealId = mealId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }
}

