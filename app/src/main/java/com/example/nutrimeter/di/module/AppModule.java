package com.example.nutrimeter.di.module;

import com.example.nutrimeter.util.UsdaUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

@Module
public class AppModule  {

    // Here I put all application dependecies for the project
    // LIKE Retrofit, Picasso, anything that is gonna exist

    // @Provides tell Dagger how to create instances of the type that this function
    // returns (i.e. LoginRetrofitService).
    // Function parameters are the dependencies of this type.
    @Singleton
    @Provides
    static Retrofit provideRetrofitInstance(){
        Timber.d("(polarizat) ---> AppModule ----> provideRetrofitInstance: RETROFIT");
        return new Retrofit.Builder()
                .baseUrl(UsdaUtils.BASE_USDA_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
