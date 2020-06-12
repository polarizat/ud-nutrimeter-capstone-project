package com.example.nutrimeter.data.model;

public class User {

    private int uID;
    private String name;
    private String email;
    private String photoUrl;
    private String[] providers;
    private ProgressEntry[] progressEntries;
    private int[] shoppingListFoodIds;
    private int[] favoritesFoodIds;
    private int[] fridgeFoodIds;

    public User(int uID, String name, String email, String photoUrl, String[] providers, ProgressEntry[] progressEntries, int[] shoppingListFoodIds, int[] favoritesFoodIds, int[] fridgeFoodIds) {
        this.uID = uID;
        this.name = name;
        this.email = email;
        this.photoUrl = photoUrl;
        this.providers = providers;
        this.progressEntries = progressEntries;
        this.shoppingListFoodIds = shoppingListFoodIds;
        this.favoritesFoodIds = favoritesFoodIds;
        this.fridgeFoodIds = fridgeFoodIds;
    }

    public int getuID() {
        return uID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String[] getProviders() {
        return providers;
    }

    public ProgressEntry[] getProgressEntries() {
        return progressEntries;
    }

    public int[] getShoppingListFoodIds() {
        return shoppingListFoodIds;
    }

    public int[] getFavoritesFoodIds() {
        return favoritesFoodIds;
    }

    public int[] getFridgeFoodIds() {
        return fridgeFoodIds;
    }
}
