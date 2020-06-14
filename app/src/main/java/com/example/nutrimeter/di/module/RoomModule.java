package com.example.nutrimeter.di.module;

import android.app.Application;

import androidx.room.Room;

import com.example.nutrimeter.data.database.FoodsDao;
import com.example.nutrimeter.data.database.NutriMeterRoomDatabase;
import com.example.nutrimeter.data.repo.FoodsRepo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {


    public NutriMeterRoomDatabase nutriMeterRoomDatabase;
    public Application application;

    public RoomModule() {
        nutriMeterRoomDatabase = Room.databaseBuilder(
                                        application,
                                        NutriMeterRoomDatabase.class,
                                        "nutri-meter-db")
                                    .build();
    }

    @Singleton
    @Provides
    public NutriMeterRoomDatabase providesRoomDatabase(Application application) {
        return nutriMeterRoomDatabase;
    }

    @Singleton
    @Provides
    public FoodsDao providesDao(NutriMeterRoomDatabase nutriMeterRoomDatabase) {
        return nutriMeterRoomDatabase.foodsDao();
    }

    @Singleton
    @Provides
    public FoodsRepo foodsRepo(FoodsDao foodsDao) {
        return new FoodsRepo(foodsDao);
    }
}
