package com.example.nutrimeter.di.module;

import com.example.nutrimeter.data.network.RetrofitClientInstance;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

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
        return RetrofitClientInstance.getRetrofitInstance();
    }



}
