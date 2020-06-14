package com.example.nutrimeter.data.model.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Food.TABLE_NAME)
public class Food {

    public static final String TABLE_NAME = "foods";
    public static final String PRIMARY_KEY_ID = "foodId";

    @PrimaryKey(autoGenerate = false)
    private int foodId;
    private int fdcId;
    private String dataType;
    private String description;
    private String ndbNumber;
    private String publicationDate;
    private String additionalDescriptions;
    private String ingredients;
    private String brandOwner;
    private String gtinUpc;

    private String servings;
    private String barCode;
    private float quantity;
    private String unit = "g";

    private String dateAdded;

    private boolean isInFridge;
    private boolean isInFavorite;
    private boolean isInShoppingList;
    private boolean isFromUSDA;

    private float calories;
    private float proteins;
    private float carbs;
    private float fats;

    private float sugars;
    private float fibers;
    private float monounsaturatedFats;
    private float polyunsaturatedFats;
    private float saturatedFats;
    private float cholesterol;
    private float sodium;

    public Food(int foodId, int fdcId, String dataType, String description, String ndbNumber,
                String publicationDate, String additionalDescriptions, String ingredients,
                String brandOwner, String gtinUpc, String servings, String barCode, float quantity,
                String unit, String dateAdded, boolean isInFridge, boolean isInFavorite,
                boolean isInShoppingList, boolean isFromUSDA, float calories, float proteins,
                float carbs, float fats, float sugars, float fibers, float monounsaturatedFats,
                float polyunsaturatedFats, float saturatedFats, float cholesterol, float sodium) {
        this.foodId = foodId;
        this.fdcId = fdcId;
        this.dataType = dataType;
        this.description = description;
        this.ndbNumber = ndbNumber;
        this.publicationDate = publicationDate;
        this.additionalDescriptions = additionalDescriptions;
        this.ingredients = ingredients;
        this.brandOwner = brandOwner;
        this.gtinUpc = gtinUpc;
        this.servings = servings;
        this.barCode = barCode;
        this.quantity = quantity;
        this.unit = unit;
        this.dateAdded = dateAdded;
        this.isInFridge = isInFridge;
        this.isInFavorite = isInFavorite;
        this.isInShoppingList = isInShoppingList;
        this.isFromUSDA = isFromUSDA;
        this.calories = calories;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.sugars = sugars;
        this.fibers = fibers;
        this.monounsaturatedFats = monounsaturatedFats;
        this.polyunsaturatedFats = polyunsaturatedFats;
        this.saturatedFats = saturatedFats;
        this.cholesterol = cholesterol;
        this.sodium = sodium;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getPrimaryKeyId() {
        return PRIMARY_KEY_ID;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getFdcId() {
        return fdcId;
    }

    public void setFdcId(int fdcId) {
        this.fdcId = fdcId;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNdbNumber() {
        return ndbNumber;
    }

    public void setNdbNumber(String ndbNumber) {
        this.ndbNumber = ndbNumber;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAdditionalDescriptions() {
        return additionalDescriptions;
    }

    public void setAdditionalDescriptions(String additionalDescriptions) {
        this.additionalDescriptions = additionalDescriptions;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getBrandOwner() {
        return brandOwner;
    }

    public void setBrandOwner(String brandOwner) {
        this.brandOwner = brandOwner;
    }

    public String getGtinUpc() {
        return gtinUpc;
    }

    public void setGtinUpc(String gtinUpc) {
        this.gtinUpc = gtinUpc;
    }

    public String getServings() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public boolean isInFridge() {
        return isInFridge;
    }

    public void setInFridge(boolean inFridge) {
        isInFridge = inFridge;
    }

    public boolean isInFavorite() {
        return isInFavorite;
    }

    public void setInFavorite(boolean inFavorite) {
        isInFavorite = inFavorite;
    }

    public boolean isInShoppingList() {
        return isInShoppingList;
    }

    public void setInShoppingList(boolean inShoppingList) {
        isInShoppingList = inShoppingList;
    }

    public boolean isFromUSDA() {
        return isFromUSDA;
    }

    public void setFromUSDA(boolean fromUSDA) {
        isFromUSDA = fromUSDA;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public float getProteins() {
        return proteins;
    }

    public void setProteins(float proteins) {
        this.proteins = proteins;
    }

    public float getCarbs() {
        return carbs;
    }

    public void setCarbs(float carbs) {
        this.carbs = carbs;
    }

    public float getFats() {
        return fats;
    }

    public void setFats(float fats) {
        this.fats = fats;
    }

    public float getSugars() {
        return sugars;
    }

    public void setSugars(float sugars) {
        this.sugars = sugars;
    }

    public float getFibers() {
        return fibers;
    }

    public void setFibers(float fibers) {
        this.fibers = fibers;
    }

    public float getMonounsaturatedFats() {
        return monounsaturatedFats;
    }

    public void setMonounsaturatedFats(float monounsaturatedFats) {
        this.monounsaturatedFats = monounsaturatedFats;
    }

    public float getPolyunsaturatedFats() {
        return polyunsaturatedFats;
    }

    public void setPolyunsaturatedFats(float polyunsaturatedFats) {
        this.polyunsaturatedFats = polyunsaturatedFats;
    }

    public float getSaturatedFats() {
        return saturatedFats;
    }

    public void setSaturatedFats(float saturatedFats) {
        this.saturatedFats = saturatedFats;
    }

    public float getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(float cholesterol) {
        this.cholesterol = cholesterol;
    }

    public float getSodium() {
        return sodium;
    }

    public void setSodium(float sodium) {
        this.sodium = sodium;
    }
}
