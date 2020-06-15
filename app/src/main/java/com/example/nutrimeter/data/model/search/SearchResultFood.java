package com.example.nutrimeter.data.model.search;

import androidx.room.Ignore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchResultFood {

    private int fdcId;
    private String dataType;
    private String description;
    private String foodCode;

    private ArrayList<AbridgedFoodNutrient> foodNutrients;

    private String publicationDate;
    private String scientificName;

    private String brandOwner;
    private String gtinUpc;

    private String ndbNumber;
    private String additionalDescriptions;
    private String allHighlightFields;
    private float score;

    public SearchResultFood(int fdcId, String dataType, String description, String foodCode, ArrayList<AbridgedFoodNutrient> foodNutrients, String publicationDate, String scientificName, String brandOwner, String gtinUpc, String ndbNumber, String additionalDescriptions, String allHighlightFields, float score) {
        this.fdcId = fdcId;
        this.dataType = dataType;
        this.description = description;
        this.foodCode = foodCode;
        this.foodNutrients = foodNutrients;
        this.publicationDate = publicationDate;
        this.scientificName = scientificName;
        this.brandOwner = brandOwner;
        this.gtinUpc = gtinUpc;
        this.ndbNumber = ndbNumber;
        this.additionalDescriptions = additionalDescriptions;
        this.allHighlightFields = allHighlightFields;
        this.score = score;
    }

    @Ignore
    public SearchResultFood(int i) {
        this.fdcId = i;
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

    public String getFoodCode() {
        return foodCode;
    }

    public void setFoodCode(String foodCode) {
        this.foodCode = foodCode;
    }

    public ArrayList<AbridgedFoodNutrient> getFoodNutrients() {
        return foodNutrients;
    }

    public void setFoodNutrients(ArrayList<AbridgedFoodNutrient> foodNutrients) {
        this.foodNutrients = foodNutrients;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
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

    public String getNdbNumber() {
        return ndbNumber;
    }

    public void setNdbNumber(String ndbNumber) {
        this.ndbNumber = ndbNumber;
    }

    public String getAdditionalDescriptions() {
        return additionalDescriptions;
    }

    public void setAdditionalDescriptions(String additionalDescriptions) {
        this.additionalDescriptions = additionalDescriptions;
    }

    public String getAllHighlightFields() {
        return allHighlightFields;
    }

    public void setAllHighlightFields(String allHighlightFields) {
        this.allHighlightFields = allHighlightFields;
    }

    public List<AbridgedFoodNutrient> getMacros(){
        List<AbridgedFoodNutrient> macros = new LinkedList<>();
        for (AbridgedFoodNutrient nutrient : foodNutrients){
            if (nutrient.getNutrientId() == 1008 ||
                nutrient.getNutrientId() == 1003 ||
                nutrient.getNutrientId() == 1005 ||
                nutrient.getNutrientId() == 1004) {
                macros.add(nutrient);
            }
        }
        return macros;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
