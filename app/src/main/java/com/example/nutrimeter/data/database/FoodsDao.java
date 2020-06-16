package com.example.nutrimeter.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.nutrimeter.data.model.room.MealFoodCrossRef;
import com.example.nutrimeter.data.model.room.MealWithFoods;
import com.example.nutrimeter.data.model.room.ProgressEntryMealCrossRef;
import com.example.nutrimeter.data.model.room.ProgressEntryWithMeals;
import com.example.nutrimeter.data.model.room.ProgressWithMealsAndFoods;
import com.example.nutrimeter.data.model.room.entity.FoodEntity;
import com.example.nutrimeter.data.model.room.entity.MealEntity;
import com.example.nutrimeter.data.model.room.entity.ProgressEntry;
import com.example.nutrimeter.data.model.room.entity.UserEntity;

import java.util.List;

@Dao
public interface FoodsDao {

    /**
     * Basic Insertions
     *
     **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFoods(FoodEntity... foodEntities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFood(FoodEntity foods);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMeals(MealEntity... mealEntities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMeal(MealEntity mealEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProgressEntry(ProgressEntry progressEntry);

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insertUser(UserEntity userEntity);



    /**
     * Basic updates
     *
     **/
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateUser(UserEntity userEntity);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateFood(FoodEntity meal);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateMeal(MealEntity mealEntity);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateProgressEntry(ProgressEntry progressEntry);




    /**
     * Queries
     *
     **/
    @Query("SELECT * FROM foodEntities WHERE foodId = :id")
    LiveData<FoodEntity> getFood(int id);


    @Query("SELECT * FROM foodEntities WHERE isInFridge = 1")
    LiveData<List<FoodEntity>> loadFoodsFromFridge();

    @Query("SELECT * FROM foodEntities WHERE isInShoppingList = 1")
    LiveData<List<FoodEntity>> loadFoodsFromShoppingList();

    @Query("SELECT * FROM foodEntities WHERE isInFavorite = 1")
    LiveData<List<FoodEntity>> loadFoodsFromFavorites();



    /**
     * Transactions
     *
     * */
    @Transaction
    @Query("SELECT * FROM mealEntities")
    LiveData<List<MealWithFoods>> getMealWithFoods();

    @Transaction
    @Query("SELECT * FROM progress_entries")
    LiveData<List<ProgressEntryWithMeals>> getProgressWithMeals();

    @Transaction
    @Query("SELECT * FROM progress_entries")
    LiveData<List<ProgressWithMealsAndFoods>> getProgressWithMealsAndFoods();




    /**
     * Basic Deletions
     *
     **/
    @Delete
    void deleteFood(FoodEntity foodEntity);

    @Delete
    void deleteMeal(MealEntity mealEntity);

    @Delete
    void deleteMeals(MealEntity... mealEntities);




    /**
     * Cross REFs
     *
     **/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMealFoodRef(MealFoodCrossRef mealFoodCrossRef);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMealFoodRefs(MealFoodCrossRef... mealFoodCrossRef);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProgressEntryMealCrossRef(ProgressEntryMealCrossRef progressEntryMealCrossRefs);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProgressEntryMealCrossRefs(ProgressEntryMealCrossRef... progressEntryMealCrossRefs);

    @Delete
    void deleteMealFoodRef(MealFoodCrossRef mealFoodCrossRef);
    @Delete
    void deleteProgressEntryMealCrossRef(ProgressEntryMealCrossRef progressEntryMealCrossRef);

}
