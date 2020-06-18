package com.example.nutrimeter.di.module;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module // @Module informs Dagger that this class is a Dagger Module
public class FirebaseModule {

/** Authentication - Firebase Auth*/
    @Singleton
    @Provides
    static FirebaseAuth provideFirebaseAuth(){
        return FirebaseAuth.getInstance();
    }


/** Remote Database -> Realtime Database*/
    @Singleton
    @Provides
    static FirebaseDatabase provideRealtimeDatabase(){
        return FirebaseDatabase.getInstance();
    }

    @Singleton
    @Provides
    @Named("users")
    static DatabaseReference provideUsersReference (FirebaseDatabase database){
        return database.getReference("users");
    }





}