package com.example.nutrimeter.data.model.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = User.TABLE_NAME)
public class User {

    public static final String TABLE_NAME = "nutrimeter_user";

    @PrimaryKey(autoGenerate = false)
    private int userId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String photoUrl;
    private String authProviders;
    private String country;

    private int age;
    private float height;
    private float currentWeight;
    private float gender;

    private String accountCreatedAt;
    private String lastSignIn;

    public User(int userId, String firstName, String lastName, String fullName, String email, String photoUrl, String authProviders, String country, int age, float height, float currentWeight, float gender, String accountCreatedAt, String lastSignIn) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.email = email;
        this.photoUrl = photoUrl;
        this.authProviders = authProviders;
        this.country = country;
        this.age = age;
        this.height = height;
        this.currentWeight = currentWeight;
        this.gender = gender;
        this.accountCreatedAt = accountCreatedAt;
        this.lastSignIn = lastSignIn;
    }



    public static String getTableName() {
        return TABLE_NAME;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getAuthProviders() {
        return authProviders;
    }

    public void setAuthProviders(String authProviders) {
        this.authProviders = authProviders;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(float currentWeight) {
        this.currentWeight = currentWeight;
    }

    public float getGender() {
        return gender;
    }

    public void setGender(float gender) {
        this.gender = gender;
    }

    public String getAccountCreatedAt() {
        return accountCreatedAt;
    }

    public void setAccountCreatedAt(String accountCreatedAt) {
        this.accountCreatedAt = accountCreatedAt;
    }

    public String getLastSignIn() {
        return lastSignIn;
    }

    public void setLastSignIn(String lastSignIn) {
        this.lastSignIn = lastSignIn;
    }
}
