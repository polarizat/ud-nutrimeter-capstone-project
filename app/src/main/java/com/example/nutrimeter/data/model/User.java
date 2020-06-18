package com.example.nutrimeter.data.model;

import com.google.firebase.database.ServerValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    public enum AuthType{PASSWORD_CREATE_ACCOUNT, PASSWORD_LOGIN, GOOGLE, ANONYMOUS}
    public static final String TAG_ANONYMOUS = "Anonymous";
    public static final String KEY_FIELD_NAME = "name";
    public static final String KEY_FIELD_EMAIL = "email";
    public static final String KEY_FIELD_PHOTO_URL = "photoUrl";
    public static final String KEY_FIELD_PROVIDERS = "authProviders";
    public static final String KEY_FIELD_AGE = "age";
    public static final String KEY_FIELD_HEIGHT = "height";
    public static final String KEY_FIELD_CURRENT_WEIGHT = "currentWeight";
    public static final String KEY_FIELD_GENDER = "gender";
    public static final String KEY_FIELD_ACCOUNT_CREATED_AT = "accountCreatedAt";
    public static final String KEY_FIELD_LAST_SIGN_IN = "lastSignIn";

    public static final int TAG_PLAN_LOSE_WEIGHT = -1;
    public static final int TAG_PLAN_MAINTAIN_WEIGHT = 0;
    public static final int TAG_PLAN_GAIN_WEIGHT = 1;

    public static final String DEFAULT_PHOTO_URL = "defaultUrl"; //Default photo //TODO

    public enum Gender{MALE, FEMALE}

    private static final int GENDER_MALE_VALUE = 1;
    private static final int GENDER_FEMALE_VALUE = 2;
    public static final int GENDER_DEFAULT = 0;

    private String uId ;
    private String name;
    private String email;
    private String photoUrl;
    private List<String> authProviders = new ArrayList<>();

    private int age;
    private float height;
    private float gender = GENDER_DEFAULT;
    private float currentWeight;
    private float goalWeight;
    private float currentPlan;

    private Map<String, String> accountCreatedAt;
    private Map<String, String> lastSignIn;

    public User(){ }

    /* Email Auth*/
    public User(String uId, String name, String email, String authProvider) {
        this.uId = uId;
        this.name = name;
        this.email = email;
        this.authProviders.add(authProvider);
        this.accountCreatedAt = getTimestamp();
        this.lastSignIn = getTimestamp();
        this.photoUrl = DEFAULT_PHOTO_URL;
    }

    /* Google Auth*/
    public User(String uId, String name, String email, String authProvider, String photoUrl) {
        this.uId = uId;
        this.name = name;
        this.email = email;
        this.authProviders.add(authProvider);
        this.accountCreatedAt = getTimestamp();
        this.lastSignIn = getTimestamp();
        this.photoUrl = photoUrl;
    }

    /* Anonymous Auth*/
    public User(String uId) {
        this.uId = uId;
        this.name = TAG_ANONYMOUS;
        this.email = TAG_ANONYMOUS;
        this.authProviders.add(TAG_ANONYMOUS);
        this.accountCreatedAt = getTimestamp();
        this.lastSignIn = getTimestamp();
        this.photoUrl = DEFAULT_PHOTO_URL;
    }

    public static String getTagAnonymous() {
        return TAG_ANONYMOUS;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<String> getAuthProviders() {
        return authProviders;
    }

    public void setAuthProviders(List<String> authProviders) {
        this.authProviders = authProviders;
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

    public void setGender(Gender gender) {
        switch (gender){
            case MALE:
                this.gender = GENDER_MALE_VALUE;
                break;
            case FEMALE:
                this.gender = GENDER_FEMALE_VALUE;
                break;
        }
    }

    public Map<String, String> getAccountCreatedAt() {
        return accountCreatedAt;
    }

    public void setAccountCreatedAt(Map<String, String> accountCreatedAt) {
        this.accountCreatedAt = accountCreatedAt;
    }

    public Map<String, String> getLastSignIn() {
        return lastSignIn;
    }

    public void setLastSignIn(Map<String, String> lastSignIn) {
        this.lastSignIn = lastSignIn;
    }

    public float getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(float goalWeight) {
        this.goalWeight = goalWeight;
    }

    public float getCurrentPlan() {
        return currentPlan;
    }

    public void setCurrentPlan(float currentPlan) {
        this.currentPlan = currentPlan;
    }

    public static Map<String, String> getTimestamp(){
        Map map = new HashMap();
        map.put("timestamp", ServerValue.TIMESTAMP);
        return map;
    }


}
