package com.example.nutrimeter.data.model;

import com.example.nutrimeter.data.model.usda.search.AbridgedFoodNutrient;
import com.example.nutrimeter.data.model.usda.search.SearchResultFood;
import com.example.nutrimeter.util.UsdaUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Food {

    public static final float DEFAULT_QUANTITY_IN_GRAMS = 100f;

    private int fdcId;

    private String dataType;
    private String description;
    private String ndbNumber;
    private String publicationDate;
    private String additionalDescriptions;
    private String ingredients;
    private String brandOwner;
    private String gtinUpc;

    List<Nutrient> mNutrients;
    private List<Nutrient> mProximates;
    private List<Nutrient> mMinerals;
    private List<Nutrient> mVitamins;
    private List<Nutrient> mMiscellaneous;
    private List<Nutrient> mPhytonutrients;

    private Nutrient calories;
    private Nutrient proteins;
    private Nutrient carbs;
    private Nutrient fats;

    private Nutrient sugars;
    private Nutrient fibers;
    private Nutrient monounsaturatedFats;
    private Nutrient polyunsaturatedFats;
    private Nutrient saturatedFats;
    private Nutrient cholesterol;
    private Nutrient sodium;

    private String servings;
    private String barCode;
    private float quantity;
    private String unit = "g";

    private String dateAdded;

    private final boolean isInMyFood;
    private boolean isInFridge;
    private boolean isInFavorite;
    private boolean isInShoppingList;
    private boolean isFromUSDA;

    public Food (SearchResultFood searchResultFood){
        this.fdcId = searchResultFood.getFdcId();
        this.dataType = searchResultFood.getDataType();
        this.description = searchResultFood.getDescription();
        this.ndbNumber = searchResultFood.getNdbNumber();
        this.publicationDate = searchResultFood.getPublicationDate();
        this.additionalDescriptions = searchResultFood.getAdditionalDescriptions();

        this.ingredients = "";
        this.brandOwner = searchResultFood.getBrandOwner();
        this.gtinUpc = searchResultFood.getGtinUpc();

        this.servings = "";
        this.barCode = "";
        this.quantity = 0f;
        this.unit = "g";

        this.dateAdded = new Date().toString();

        this.isInMyFood = true;
        this.isInFridge = false;
        this.isInFavorite = false;
        this.isInShoppingList = false;
        this.isFromUSDA = true;

        Nutrient nutrient;
        mNutrients = new ArrayList<>();
        mProximates = new ArrayList<>();
        mMinerals = new ArrayList<>();
        mVitamins = new ArrayList<>();
        mMiscellaneous = new ArrayList<>();
        mPhytonutrients = new ArrayList<>();

        for (AbridgedFoodNutrient abridgedFoodNutrient : searchResultFood.getFoodNutrients()){
            nutrient = new Nutrient(abridgedFoodNutrient);
            mNutrients .add(nutrient);

            switch (nutrient.getCategoryNumber()){
                case (UsdaUtils.CATEGORY_PROXIMATES):
                    mProximates.add(nutrient);
                    break;
                case (UsdaUtils.CATEGORY_MINERALS):
                    mMinerals.add(nutrient);
                    break;
                case (UsdaUtils.CATEGORY_VITAMINS_AND_OTHER_COMPONENTS):
                    mVitamins.add(nutrient);
                    break;
                case (UsdaUtils.CATEGORY_MISCELLANEOUS):
                    mMiscellaneous.add(nutrient);
                    break;
                case (UsdaUtils.CATEGORY_PHYTONUTRIENTS):
                    mPhytonutrients.add(nutrient);
                    break;
                default: break;
            }

            switch (nutrient.getNutrientNumber()){
                case UsdaUtils.ENERGY_KCAL:
                    this.calories = nutrient;
                    break;
                case UsdaUtils.PROTEIN:
                    this.proteins = nutrient;
                    break;
                case UsdaUtils.CARBOHYDRATE_BY_DIFFERENCE:
                    this.carbs = nutrient;
                    break;
                case UsdaUtils.TOTAL_LIPID_FAT:
                    this.fats = nutrient;
                    break;
                case UsdaUtils.SUGARS_TOTAL_INCLUDING_NLEA:
                    this.sugars = nutrient;
                    break;
                case UsdaUtils.DIETARY_FIBERS:
                    this.fibers = nutrient;
                    break;
                case UsdaUtils.FATTY_ACIDS_SATURATED:
                    this.saturatedFats = nutrient;
                    break;
                case UsdaUtils.FATTY_ACIDS_MONOUNSATURATED:
                    this.monounsaturatedFats = nutrient;
                    break;
                case UsdaUtils.FATTY_ACIDS_POLYUNSATURATED:
                    this.polyunsaturatedFats = nutrient;
                    break;
                case UsdaUtils.CHOLESTEROL:
                    this.cholesterol = nutrient;
                    break;
                case UsdaUtils.SODIUM:
                    this.sodium = nutrient;
                    break;
            }
        }
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

    public List<Nutrient> getmNutrients() {
        return mNutrients;
    }

    public void setmNutrients(List<Nutrient> mNutrients) {
        this.mNutrients = mNutrients;
    }

    public List<Nutrient> getmProximates() {
        return mProximates;
    }

    public void setmProximates(List<Nutrient> mProximates) {
        this.mProximates = mProximates;
    }

    public List<Nutrient> getmMinerals() {
        return mMinerals;
    }

    public void setmMinerals(List<Nutrient> mMinerals) {
        this.mMinerals = mMinerals;
    }

    public List<Nutrient> getmVitamins() {
        return mVitamins;
    }

    public void setmVitamins(List<Nutrient> mVitamins) {
        this.mVitamins = mVitamins;
    }

    public List<Nutrient> getmMiscellaneous() {
        return mMiscellaneous;
    }

    public void setmMiscellaneous(List<Nutrient> mMiscellaneous) {
        this.mMiscellaneous = mMiscellaneous;
    }

    public List<Nutrient> getmPhytonutrients() {
        return mPhytonutrients;
    }

    public void setmPhytonutrients(List<Nutrient> mPhytonutrients) {
        this.mPhytonutrients = mPhytonutrients;
    }

    public Nutrient getCalories() {
        return calories;
    }

    public void setCalories(Nutrient calories) {
        this.calories = calories;
    }

    public Nutrient getProteins() {
        return proteins;
    }

    public void setProteins(Nutrient proteins) {
        this.proteins = proteins;
    }

    public Nutrient getCarbs() {
        return carbs;
    }

    public void setCarbs(Nutrient carbs) {
        this.carbs = carbs;
    }

    public Nutrient getFats() {
        return fats;
    }

    public void setFats(Nutrient fats) {
        this.fats = fats;
    }

    public Nutrient getSugars() {
        return sugars;
    }

    public void setSugars(Nutrient sugars) {
        this.sugars = sugars;
    }

    public Nutrient getFibers() {
        return fibers;
    }

    public void setFibers(Nutrient fibers) {
        this.fibers = fibers;
    }

    public Nutrient getMonounsaturatedFats() {
        return monounsaturatedFats;
    }

    public void setMonounsaturatedFats(Nutrient monounsaturatedFats) {
        this.monounsaturatedFats = monounsaturatedFats;
    }

    public Nutrient getPolyunsaturatedFats() {
        return polyunsaturatedFats;
    }

    public void setPolyunsaturatedFats(Nutrient polyunsaturatedFats) {
        this.polyunsaturatedFats = polyunsaturatedFats;
    }

    public Nutrient getSaturatedFats() {
        return saturatedFats;
    }

    public void setSaturatedFats(Nutrient saturatedFats) {
        this.saturatedFats = saturatedFats;
    }

    public Nutrient getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(Nutrient cholesterol) {
        this.cholesterol = cholesterol;
    }

    public Nutrient getSodium() {
        return sodium;
    }

    public void setSodium(Nutrient sodium) {
        this.sodium = sodium;
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

    public boolean isInMyFood() {
        return isInMyFood;
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
}
