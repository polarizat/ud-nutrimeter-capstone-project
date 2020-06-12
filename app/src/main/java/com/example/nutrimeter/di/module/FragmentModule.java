package com.example.nutrimeter.di.module;

import com.example.nutrimeter.di.module.diary.DiaryViewModelsModule;
import com.example.nutrimeter.di.module.me.MeViewModelsModule;
import com.example.nutrimeter.ui.diary.Diary;
import com.example.nutrimeter.ui.me.Me;
import com.example.nutrimeter.ui.my_food.MyFood;
import com.example.nutrimeter.ui.shopping_list.ShoppingList;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class FragmentModule {
    /*
     * We define the name of the Fragments we are going to inject the ViewModelFactory into.
     */


    /*DIARY*/
    @ContributesAndroidInjector(modules = {
            DiaryViewModelsModule.class,
    })
    abstract Diary contributeDiaryFragment();

    /*Me*/
    @ContributesAndroidInjector(modules = {
            MeViewModelsModule.class,
    })
    abstract Me contributeMeFragment();

    /*MY FOOD*/
    @ContributesAndroidInjector
    abstract MyFood contributeMyFoodFragment();


    /*MY FOOD*/
    @ContributesAndroidInjector
    abstract ShoppingList contributeShoppingListFragment();

}
