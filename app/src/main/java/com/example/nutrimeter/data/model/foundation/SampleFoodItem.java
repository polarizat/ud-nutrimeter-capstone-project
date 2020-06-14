package com.example.nutrimeter.data.model.foundation;

import com.example.nutrimeter.data.model.common.FoodCategory;

import java.util.List;

public class SampleFoodItem {

    public static final String SAMPLE_FOOD_ITEM_FIELD_FCD_ID = "fcdId";
    public static final String SAMPLE_FOOD_ITEM_FIELD_DATA_TYPE = "dataType";
    public static final String SAMPLE_FOOD_ITEM_FIELD_DESCRIPTION = "description";
    public static final String SAMPLE_FOOD_ITEM_FIELD_FOOD_CLASS = "foodClass";
    public static final String SAMPLE_FOOD_ITEM_FIELD_PUBLICATION_DATE = "publicationDate";
    public static final String SAMPLE_FOOD_ITEM_FIELD_FOOD_ATTRIBUTES = "foodAttributes";

    private int fdcId;
    private String dataType;
    private String description;
    private String foodClass;
    private String publicationDate;
    private List<FoodCategory> foodAttributes;

    public SampleFoodItem(int fdcId, String dataType, String description, String foodClass, String publicationDate, List<FoodCategory> foodAttributes) {
        this.fdcId = fdcId;
        this.dataType = dataType;
        this.description = description;
        this.foodClass = foodClass;
        this.publicationDate = publicationDate;
        this.foodAttributes = foodAttributes;
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

    public String getFoodClass() {
        return foodClass;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public List<FoodCategory> getFoodAttributes() {
        return foodAttributes;
    }
}
