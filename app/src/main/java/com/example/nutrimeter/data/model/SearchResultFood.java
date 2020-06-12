package com.example.nutrimeter.data.model;

public class SearchResultFood {

    private int fdcId;
    private String dataType;
    private String description;
    private String foodCode;

    private AbridgedFoodNutrient[] foodNutrients;

    private String publicationDate;
    private String scientificName;
    private String ndbNumber;
    private String additionalDescriptions;
    private String allHighlightFields;
    private float score;


    public SearchResultFood(int fdcId, String dataType, String description, String foodCode, AbridgedFoodNutrient[] foodNutrients, String publicationDate, String scientificName, String ndbNumber, String additionalDescriptions, String allHighlightFields, float score) {
        this.fdcId = fdcId;
        this.dataType = dataType;
        this.description = description;
        this.foodCode = foodCode;
        this.foodNutrients = foodNutrients;
        this.publicationDate = publicationDate;
        this.scientificName = scientificName;
        this.ndbNumber = ndbNumber;
        this.additionalDescriptions = additionalDescriptions;
        this.allHighlightFields = allHighlightFields;
        this.score = score;
    }

    public int getFdcId() {
        return fdcId;
    }

    public String getDataType() {
        return dataType;
    }

    public String getDescription() {
        return description;
    }

    public String getFoodCode() {
        return foodCode;
    }

    public AbridgedFoodNutrient[] getFoodNutrients() {
        return foodNutrients;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getNdbNumber() {
        return ndbNumber;
    }

    public String getAdditionalDescriptions() {
        return additionalDescriptions;
    }

    public String getAllHighlightFields() {
        return allHighlightFields;
    }

    public float getScore() {
        return score;
    }
}
