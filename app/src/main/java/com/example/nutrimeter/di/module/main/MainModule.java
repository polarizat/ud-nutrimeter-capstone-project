package com.example.nutrimeter.di.module.main;

import com.example.nutrimeter.data.repo.UsdaRepo;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import timber.log.Timber;

@Module
public class MainModule {


    @Provides
    @MainScope
    UsdaRepo providesUsdaRepo(Retrofit retrofit){
        Timber.d("(polarizat) ---> MainModule ----> providesUsdaRepo: RETROFIT");
        return new UsdaRepo(retrofit);
    }


}
