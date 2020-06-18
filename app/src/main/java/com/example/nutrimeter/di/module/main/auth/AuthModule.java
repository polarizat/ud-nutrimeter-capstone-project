package com.example.nutrimeter.di.module.main.auth;

import com.example.nutrimeter.data.repo.AuthRepo;
import com.example.nutrimeter.di.module.main.MainScope;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class AuthModule {

    @Provides
    @MainScope
    static AuthRepo providesAuthRepo(FirebaseAuth firebaseAuth, @Named("users") DatabaseReference ref){
        return new AuthRepo(firebaseAuth, ref);
    }

}
