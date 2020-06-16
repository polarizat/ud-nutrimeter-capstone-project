package com.example.nutrimeter.data.model.usda.foundation;

import com.example.nutrimeter.data.model.usda.common.FoodCategory;
import com.example.nutrimeter.data.model.usda.common.FoodNutrient;
import com.example.nutrimeter.data.model.usda.common.NutrientConversionFactors;

import java.util.ArrayList;

public class FoundationFoodItem {

    private static final String FOUNDATION_FOOD_ITEM_FIELD_FCD_ID = "fcdID";
    private static final String FOUNDATION_FOOD_ITEM_FIELD_DATA_TYPES = "dataType";
    private static final String FOUNDATION_FOOD_ITEM_FIELD_DESCRIPTION = "description";
    private static final String FOUNDATION_FOOD_ITEM_FIELD_FOOD_CLASS = "foodClass";
    private static final String FOUNDATION_FOOD_ITEM_FIELD_FOOD_NOTE = "foodNote";
    private static final String FOUNDATION_FOOD_ITEM_FIELD_IS_HISTORICAL_REFERENCE = "isHistoricalReference";
    private static final String FOUNDATION_FOOD_ITEM_FIELD_NDB_NUMBER = "ndbNumber";
    private static final String FOUNDATION_FOOD_ITEM_FIELD_PUBLICATION_DATE = "publicationDate";
    private static final String FOUNDATION_FOOD_ITEM_FIELD_SCIENTIFIC_NAME = "scientificName";
    private static final String FOUNDATION_FOOD_ITEM_FIELD_FOOD_CATEGORY = "foodCategory";
    private static final String FOUNDATION_FOOD_ITEM_FIELD_FOOD_COMPONENTS = "foodComponents";
    private static final String FOUNDATION_FOOD_ITEM_FIELD_FOOD_NUTRIENTS = "foodNutrients";
    private static final String FOUNDATION_FOOD_ITEM_FIELD_FCD_FOOD_PORTIONS = "foodPortions";
    private static final String FOUNDATION_FOOD_ITEM_FIELD_FCD_INPUT_FOODS = "inputFoods";
    private static final String FOUNDATION_FOOD_ITEM_FIELD_FCD_NUTRIENT_CONVERSION_FACTORS = "nutrientConversionFactors";

    private int fdcId;
    private String dataType;
    private String description;


    private String foodClass;
    private String foodNote;
    private boolean isHistoricalReference;
    private String ndbNumber;
    private String publicationDate;
    private String scientificName;

    private FoodCategory foodCategory;

    private ArrayList<FoodComponent> foodComponents;
    private ArrayList<FoodNutrient> foodNutrients;
    private ArrayList<FoodPortion> foodPortions;
    private ArrayList<InputFoodFoundation> inputFoods;

    private ArrayList<NutrientConversionFactors> nutrientConversionFactors;

    public FoundationFoodItem(int fdcId, String dataType, String description, String foodClass, String foodNote, boolean isHistoricalReference, String ndbNumber, String publicationDate, String scientificName, FoodCategory foodCategory, ArrayList<FoodComponent> foodComponents, ArrayList<FoodNutrient> foodNutrients, ArrayList<FoodPortion> foodPortions, ArrayList<InputFoodFoundation> inputFoods, ArrayList<NutrientConversionFactors> nutrientConversionFactors) {
        this.fdcId = fdcId;
        this.dataType = dataType;
        this.description = description;
        this.foodClass = foodClass;
        this.foodNote = foodNote;
        this.isHistoricalReference = isHistoricalReference;
        this.ndbNumber = ndbNumber;
        this.publicationDate = publicationDate;
        this.scientificName = scientificName;
        this.foodCategory = foodCategory;
        this.foodComponents = foodComponents;
        this.foodNutrients = foodNutrients;
        this.foodPortions = foodPortions;
        this.inputFoods = inputFoods;
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

    public String getFoodNote() {
        return foodNote;
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

    public ArrayList<FoodComponent> getFoodComponents() {
        return foodComponents;
    }

    public ArrayList<FoodNutrient> getFoodNutrients() {
        return foodNutrients;
    }

    public ArrayList<FoodPortion> getFoodPortions() {
        return foodPortions;
    }

    public ArrayList<InputFoodFoundation> getInputFoods() {
        return inputFoods;
    }

    public ArrayList<NutrientConversionFactors> getNutrientConversionFactors() {
        return nutrientConversionFactors;
    }
}
