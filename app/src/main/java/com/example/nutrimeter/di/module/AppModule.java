package com.example.nutrimeter.di.module;

import com.example.nutrimeter.util.UsdaUtils;
import com.google.firebase.auth.FirebaseAuth;

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


    @Singleton
    @Provides
    static FirebaseAuth provideFirebaseAuth(){
        return FirebaseAuth.getInstance();
    }

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
