package com.example.nutrimeter.di.module.main;

import androidx.lifecycle.ViewModel;

import com.example.nutrimeter.di.ViewModelKey;
import com.example.nutrimeter.ui.MainActivityViewModel;
import com.example.nutrimeter.ui.auth.AuthViewModel;
import com.example.nutrimeter.ui.diary.DiaryViewModel;
import com.example.nutrimeter.ui.food_detail.FoodDetailViewModel;
import com.example.nutrimeter.ui.me.MeViewModel;
import com.example.nutrimeter.ui.my_food.MyFoodViewModel;
import com.example.nutrimeter.ui.search_food.SearchUsdaViewModel;
import com.example.nutrimeter.ui.shopping_list.ShoppingListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelBuildersModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    public abstract ViewModel bindMainViewModel(MainActivityViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(SearchUsdaViewModel.class)
    public abstract ViewModel bindSearchUsdaViewModel(SearchUsdaViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(FoodDetailViewModel.class)
    public abstract ViewModel bindFoodDetailViewModel(FoodDetailViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DiaryViewModel.class)
    public abstract ViewModel bindDiaryViewModel(DiaryViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MeViewModel.class)
    public abstract ViewModel bindMeViewModel(MeViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MyFoodViewModel.class)
    public abstract ViewModel bindMyFoodViewModel(MyFoodViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ShoppingListViewModel.class)
    public abstract ViewModel bindShoppingListViewModel(ShoppingListViewModel viewModel);



}
