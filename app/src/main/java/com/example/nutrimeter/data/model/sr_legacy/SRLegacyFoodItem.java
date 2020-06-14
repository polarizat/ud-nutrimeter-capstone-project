package com.example.nutrimeter.data.model.sr_legacy;

import com.example.nutrimeter.data.model.common.FoodCategory;
import com.example.nutrimeter.data.model.common.FoodNutrient;
import com.example.nutrimeter.data.model.common.NutrientConversionFactors;

import java.util.ArrayList;

public class SRLegacyFoodItem {

    public final static String SR_LEGACY_FOOD_ITEM_FIELD_FDC_ID = "fdcId";
    public final static String SR_LEGACY_FOOD_ITEM_FIELD_DATA_TYPE = "dataType";
    public final static String SR_LEGACY_FOOD_ITEM_FIELD_DESCRIPTION = "description";
    public final static String SR_LEGACY_FOOD_ITEM_FIELD_FOOD_CLASS = "foodClass";
    public final static String SR_LEGACY_FOOD_ITEM_FIELD_IS_HISTORICAL_REFERENCE = "isHistoricalReference";
    public final static String SR_LEGACY_FOOD_ITEM_FIELD_NDB_NUMBER = "ndbNumber";
    public final static String SR_LEGACY_FOOD_ITEM_FIELD_PUBLICATION_DATE = "publicationDate";
    public final static String SR_LEGACY_FOOD_ITEM_FIELD_SCIENTIFIC_NAME = "scientificName";
    public final static String SR_LEGACY_FOOD_ITEM_FIELD_FOOD_CATEGORY = "foodCategory";
    public final static String SR_LEGACY_FOOD_ITEM_FIELD_FOOD_NUTRIENTS = "foodNutrients";
    public final static String SR_LEGACY_FOOD_ITEM_FIELD_NUTRIENT_CONVERSION_FACTORY = "nutrientConversionFactors";

    // *Mandatory
    private int fdcId;
    private String dataType;
    private String description;


    private String foodClass;
    private boolean isHistoricalReference;
    private String ndbNumber;
    private String publicationDate;
    private String scientificName;

    private FoodCategory foodCategory;
    private ArrayList<FoodNutrient> foodNutrients;
    private ArrayList<NutrientConversionFactors> nutrientConversionFactors;

    public SRLegacyFoodItem(int fdcId, String dataType, String description, String foodClass, boolean isHistoricalReference, String ndbNumber, String publicationDate, String scientificName, FoodCategory foodCategory, ArrayList<FoodNutrient> foodNutrients, ArrayList<NutrientConversionFactors> nutrientConversionFactors) {
        this.fdcId = fdcId;
        this.dataType = dataType;
        this.description = description;
        this.foodClass = foodClass;
        this.isHistoricalReference = isHistoricalReference;
        this.ndbNumber = ndbNumber;
        this.publicationDate = publicationDate;
        this.scientificName = scientificName;
        this.foodCategory = foodCategory;
        this.foodNutrients = foodNutrients;
        this.nutrientConversionFactors = nutrientConversionFactors;
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

    public boolean isHistoricalReference() {
        return isHistoricalReference;
    }

    public String getNdbNumber() {
        return ndbNumber;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getScientificName() {
        return scientificName;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public ArrayList<FoodNutrient> getFoodNutrients() {
        return foodNutrients;
    }

    public ArrayList<NutrientConversionFactors> getNutrientConversionFactors() {
        return nutrientConversionFactors;
    }
}
