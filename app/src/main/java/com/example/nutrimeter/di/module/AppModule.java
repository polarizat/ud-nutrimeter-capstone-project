package com.example.nutrimeter.di.module;

import android.app.Application;

import com.example.nutrimeter.data.model.Food;
import com.example.nutrimeter.util.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule  {

    // Here I put all application dependecies for the project
    // LIKE Retrofit, Picasso, anything that is gonna exist
    @Singleton
    @Provides
    static Retrofit provideRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_USDA_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build() ;
    }


}
