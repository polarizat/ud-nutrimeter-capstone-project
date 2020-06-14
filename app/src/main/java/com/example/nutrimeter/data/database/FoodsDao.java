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
import com.example.nutrimeter.data.model.room.entity.Food;
import com.example.nutrimeter.data.model.room.entity.Meal;
import com.example.nutrimeter.data.model.room.entity.ProgressEntry;
import com.example.nutrimeter.data.model.room.entity.User;

import java.util.List;

@Dao
public interface FoodsDao {

    /**
     * Basic Insertions
     *
     **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFoods(Food... foods);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFood(Food foods);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMeals(Meal... meals);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMeal(Meal meal);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProgressEntry(ProgressEntry progressEntry);

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insertUser(User user);



    /**
     * Basic updates
     *
     **/
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateUser(User user);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateFood(Food meal);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateMeal(Meal meal);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateProgressEntry(ProgressEntry progressEntry);




    /**
     * Queries
     *
     **/
    @Query("SELECT * FROM foods WHERE foodId = :id")
    LiveData<Food> getFood(int id);


    @Query("SELECT * FROM foods WHERE isInFridge = 1")
    public LiveData<List<Food>> loadFoodsFromFridge();

    @Query("SELECT * FROM foods WHERE isInShoppingList = 1")
    public LiveData<List<Food>> loadFoodsFromShoppingList();

    @Query("SELECT * FROM foods WHERE isInFavorite = 1")
    public LiveData<List<Food>> loadFoodsFromFavorites();



    /**
     * Transactions
     *
     * */
    @Transaction
    @Query("SELECT * FROM meals")
    public LiveData<List<MealWithFoods>> getMealWithFoods();

    @Transaction
    @Query("SELECT * FROM progress_entries")
    public LiveData<List<ProgressEntryWithMeals>> getProgressWithMeals();

    @Transaction
    @Query("SELECT * FROM progress_entries")
    public LiveData<List<ProgressWithMealsAndFoods>> getProgressWithMealsAndFoods();




    /**
     * Basic Deletions
     *
     **/
    @Delete
    void deleteFood(Food food);

    @Delete
    void deleteMeal(Meal meal);

    @Delete
    void deleteMeals(Meal... meals);




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
