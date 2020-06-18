package com.example.nutrimeter.di.module.main;

import com.example.nutrimeter.ui.auth.Auth;
import com.example.nutrimeter.ui.auth.AuthAnonymous;
import com.example.nutrimeter.ui.auth.AuthEmailAndPassword;
import com.example.nutrimeter.ui.auth.AuthEmailAndPasswordCreateAccount;
import com.example.nutrimeter.ui.auth.AuthEmailAndPasswordLogin;
import com.example.nutrimeter.ui.auth.AuthWithGoogle;
import com.example.nutrimeter.ui.auth.firstConfig.EnterAgeFragment;
import com.example.nutrimeter.ui.auth.firstConfig.EnterHeightFragment;
import com.example.nutrimeter.ui.auth.firstConfig.EnterWeightFragment;
import com.example.nutrimeter.ui.auth.firstConfig.SelectGenderFragment;
import com.example.nutrimeter.ui.auth.firstConfig.SelectPlanFragment;
import com.example.nutrimeter.ui.diary.Diary;
import com.example.nutrimeter.ui.food_detail.FoodDetail;
import com.example.nutrimeter.ui.me.Me;
import com.example.nutrimeter.ui.my_food.MyFood;
import com.example.nutrimeter.ui.search_food.SearchUsda;
import com.example.nutrimeter.ui.shopping_list.ShoppingList;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {
    /*
     * We define the name of the Fragments we are going to inject the ViewModelFactory into.
     */

    /*AUTH*/
    @ContributesAndroidInjector abstract Auth contributeAuthFragment();

    @ContributesAndroidInjector abstract AuthEmailAndPassword contributeAuthEmailAndPassword();
    @ContributesAndroidInjector abstract AuthEmailAndPasswordLogin contributeAuthLogin();
    @ContributesAndroidInjector abstract AuthEmailAndPasswordCreateAccount contributeAuthCreateAccount();

    @ContributesAndroidInjector abstract AuthWithGoogle contributeAuthWithGoogle();
    @ContributesAndroidInjector abstract AuthAnonymous contributeAuthAnonymous();

    /*AUTH  --- CONFIG*/
    @ContributesAndroidInjector abstract EnterAgeFragment contributeEnterAgeFragment();
    @ContributesAndroidInjector abstract EnterHeightFragment contributeEnterHeightFragment();
    @ContributesAndroidInjector abstract EnterWeightFragment contributeEnterWeightFragment();
    @ContributesAndroidInjector abstract SelectGenderFragment contributeSelectGenderFragment();
    @ContributesAndroidInjector abstract SelectPlanFragment contributeSelectPlanFragment();


    /*SEARCH*/
    @ContributesAndroidInjector
    abstract SearchUsda contributeSearchUsdaFragment();

    /*FOOD DETAILS*/
    @ContributesAndroidInjector
    abstract FoodDetail contributeFoodDetailFragment();


    /*DIARY*/
    @ContributesAndroidInjector
    abstract Diary contributeDiaryFragment();




    /*Me*/
    @ContributesAndroidInjector
    abstract Me contributeMeFragment();




    /*MY FOOD*/
    @ContributesAndroidInjector
    abstract MyFood contributeMyFoodFragment();





    /*MY FOOD*/
    @ContributesAndroidInjector
    abstract ShoppingList contributeShoppingListFragment();

}
