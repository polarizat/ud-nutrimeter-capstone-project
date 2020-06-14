package com.example.nutrimeter.di.module.main.auth;

import com.example.nutrimeter.data.repo.AuthRepo;
import com.example.nutrimeter.di.module.main.MainScope;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class AuthModule {

    @Provides
    @MainScope
    static AuthRepo providesAuthRepo(){
        return new AuthRepo();
    }

}
