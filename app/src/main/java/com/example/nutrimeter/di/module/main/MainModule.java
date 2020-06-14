package com.example.nutrimeter.di.module.main;

import com.example.nutrimeter.data.repo.AuthRepo;
import com.example.nutrimeter.data.repo.UsdaRepo;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    Retrofit retrofit;

    @Provides
    @MainScope
    UsdaRepo providesUsdaRepo(){
        return new UsdaRepo(retrofit);
    }


}
