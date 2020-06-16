package com.example.nutrimeter.util;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class UsdaUtils {

    public static final String BASE_USDA_URL = "https://api.nal.usda.gov";
    public static final String USDA_MAIN_PATH = "/fdc/v1";

    public static final String USDA_QUERY_FIELD_API_KEY = "api_key";

    /**
     * Search for foods using keywords. Results can be filtered by dataType and there are options
     * for result page sizes or sorting.
     *
     * /v1/foods/search
     *
     */

    public static final String USDA_SEARCH_PATH_FOODS = "/foods";
    public static final String USDA_SEARCH_PATH_SEARCH = "/search";
    public static final String USDA_SEARCH_QUERY_FIELD = "query"; // (String) - REQUIRED

    public enum SearchDataType {FOUNDATION, SR_LEGACY, SURVEY_FNDDS, BRANDED}
    public static final String USDA_SEARCH_QUERY_FIELD_DATA_TYPE = "dataType";     // (String) - optional
    public static final String USDA_SEARCH_QUERY_PARAM_DATA_TYPE_FOUNDATION = "Foundation";
    public static final String USDA_SEARCH_QUERY_PARAM_DATA_TYPE_SR_LEGACY = "SR Legacy";
    public static final String USDA_SEARCH_QUERY_PARAM_DATA_TYPE_SURVEY_FNDDS = "Survey (FNDDS)";
    public static final String USDA_SEARCH_QUERY_PARAM_DATA_TYPE_BRANDED = "Branded";

    public static final String USDA_SEARCH_QUERY_FIELD_PAGE_SIZE = "pageSize";     // (integer) - optional
    public static final String USDA_SEARCH_QUERY_FIELD_PAGE_NUMBER = "pageNumber"; // (integer) - optional

    public enum SearchSortBy { DATA_TYPE, LOWERCASE_DESCRIPTION, FDC_ID, PUBLISHED_DATE}
    public static final String USDA_SEARCH_QUERY_FIELD_SORT_BY = "sortBy";         // (String) - optional
    public static final String USDA_SEARCH_QUERY_PARAM_SORT_BY_DATA_TYPE_KEYWORD = "dataType.keyword";
    public static final String USDA_SEARCH_QUERY_PARAM_SORT_BY_DATA_LOWERCASE_DESC_KEYWORD = "lowercaseDescription.keyword";
    public static final String USDA_SEARCH_QUERY_PARAM_SORT_BY_FDC_ID = "fdcId";
    public static final String USDA_SEARCH_QUERY_PARAM_SORT_BY_PUBLISHED_DATE = "publishedDate";

    public enum SearchSortOrder {ASC, DESC}
    public static final String USDA_SEARCH_FIELD_SORT_ORDER = "sortOrder";   // (String) - optional
    public static final String USDA_SEARCH_PARAM_ASC = "asc";
    public static final String USDA_SEARCH_PARAM_DESC = "desc";

    public static final String USDA_SEARCH_FIELD_BRAND_OWNER = "brandOwner";   // (String) - optional

    /**
     * Fetches details for one food item by FDC ID*
     *
     * /v1/food/{fdcId}
     *
     */
    public static final String USDA_FOOD_PATH_FOOD = "/food";
    public static final String USDA_FOOD_PATH_FDC_ID = "fdcId"; // (String) -> REQUIRED

    public static final String USDA_FOOD_QUERY_FIELD_FORMAT = "format";  // (String) - optional
    public static final String USDA_FOOD_QUERY_PARAM_FORMAT_ABRIDGED = "abridged";
    public static final String USDA_FOOD_QUERY_PARAM_FORMAT_FULL = "full";

    public static final String USDA_FOOD_QUERY_FIELD_NUTRIENTS = "nutrients"; // (array[integer]) - optional

    /**
     * Retrieves a list of food items by a list of up to 20 FDC IDs.
     * Optional format and nutrients can be specified. Invalid FDC ID's or ones that are not found
     * are omitted and an empty set is returned if there are no matches.
     *
     * /v1/foods/
     *
     */
    public enum FoodsFormat {ABRIDGED, FULL}
    public static final String USDA_FOODS_QUERY_FIELD_FORMAT = "format";  // (String) - optional
    public static final String USDA_FOODS_QUERY_PARAM_FORMAT_ABRIDGED = "abridged";
    public static final String USDA_FOODS_QUERY_PARAM_FORMAT_FULL = "full";

    public static final String USDA_FOODS_QUERY_FIELD_NUTRIENTS = "nutrients"; // (array[integer]) - optional


    /**
     * Retrieves a paged list of foods.
     * Use the pageNumber parameter to page through the entire result set.
     *
     * /v1/food/list
     * */
    public static final String USDA_LIST_PATH_LIST = "/list";

    public enum ListDataType {FOUNDATION, SR_LEGACY, SURVEY_FNDDS, BRANDED}
    public static final String USDA_LIST_QUERY_FIELD_DATA_TYPE = "dataType";     // (String) - optional
    public static final String USDA_LIST_QUERY_PARAM_DATA_TYPE_FOUNDATION = "Foundation";
    public static final String USDA_LIST_QUERY_PARAM_DATA_TYPE_SR_LEGACY = "SR Legacy";
    public static final String USDA_LIST_QUERY_PARAM_DATA_TYPE_SURVEY_FNDDS = "Survey (FNDDS)";
    public static final String USDA_LIST_QUERY_PARAM_DATA_TYPE_BRANDED = "Branded";

    public static final String USDA_LIST_QUERY_FIELD_PAGE_SIZE = "pageSize";     // (integer) - optional
    public static final String USDA_LIST_QUERY_FIELD_PAGE_NUMBER = "pageNumber"; // (integer) - optional

    public enum ListSortBy { DATA_TYPE, LOWERCASE_DESCRIPTION, FDC_ID, PUBLISHED_DATE}
    public static final String USDA_LIST_QUERY_FIELD_SORT_BY = "sortBy";         // (String) - optional
    public static final String USDA_LIST_QUERY_PARAM_SORT_BY_DATA_TYPE_KEYWORD = "dataType.keyword";
    public static final String USDA_LIST_QUERY_PARAM_SORT_BY_DATA_LOWERCASE_DESC_KEYWORD = "lowercaseDescription.keyword";
    public static final String USDA_LIST_QUERY_PARAM_SORT_BY_FDC_ID = "fdcId";
    public static final String USDA_LIST_QUERY_PARAM_SORT_BY_PUBLISHED_DATE = "publishedDate";

    public enum ListSortOrder {ASC, DESC}
    public static final String USDA_LIST_QUERY_FIELD_SORT_ORDER = "sortOrder";   // (String) - optional
    public static final String USDA_LIST_QUERY_PARAM_ASC = "asc";
    public static final String USDA_LIST_QUERY_PARAM_DESC = "desc";


    /**
     * NUTRIENT CATEGORIES ---------------V
     * */
    public static final int CATEGORY_PROXIMATES = 951;
    public static final int CATEGORY_AMINO_ACIDS = 500;
    public static final int CATEGORY_LIPIDS = 950;
    public static final int CATEGORY_MINERALS = 300;
    public static final int CATEGORY_VITAMINS_AND_OTHER_COMPONENTS = 952;
    public static final int CATEGORY_MISCELLANEOUS = 2000;
    public static final int CATEGORY_PHYTONUTRIENTS = 2100;


    /**
     * PROXIMATES ---------------V
     * */
    public static final int PROTEIN = 203;
        public static final int TOTAL_LIPID_FAT = 204;
        public static final int ASH = 207;

        public static final int ENERGY_KCAL = 208;
        public static final int ENERGY_KJ = 268;

        public static final int SUBCATEGORY_PROXIMATES_CARBOHYDRATES = 956;
        /* -----------------------------------------------V */
        public static final int CARBOHYDRATE_BY_DIFFERENCE = 205;
            public static final int DIETARY_FIBERS = 291;
            public static final int SUGARS_TOTAL_INCLUDING_NLEA = 269;
                public static final int SUCROSE = 210;
                public static final int GLUCOSE_DEXTROSE = 211;
                public static final int FRUCTOSE = 212;
                public static final int LACTOSE = 213;
                public static final int MALTOSE = 214;
                public static final int GALACTOSE = 287;
            public static final int STARCH = 209;

    public static final int ALCOHOL_ETHYL = 221;
    public static final int WATER = 255;

    public static final int CAFFEINE = 262;
    public static final int THEBROMINE = 263;

    /**
     * AMINO ACIDS ---------------V
     * */
    public static final int TRYPTOPHAN = 501;
    public static final int THREONINE = 502;
    public static final int ISOLEUCINE = 503;
    public static final int LEUCINE = 504;
    public static final int LYSINE = 505;
    public static final int METHIONINE = 506;
    public static final int CYSTINE = 507;
    public static final int PHENYLALANINE = 508;
    public static final int TYROSINE = 509;
    public static final int VALINE = 510;
    public static final int ARGININE = 511;
    public static final int HISTIDINE = 512;
    public static final int ALANINE = 513;
    public static final int ASPARTIC_ACID = 514;
    public static final int GLUTAMIC_ACID = 515;
    public static final int GLYCINE = 516;
    public static final int PROLINE = 517;
    public static final int SERINE = 518;
    public static final int HYDROXYPROLINE = 519;


    /**
     * LIPIDS ---------------V
     * */
    public static final int CHOLESTEROL = 601;

    public static final int FATTY_ACIDS_SATURATED = 606;
        public static final int FATTY_ACIDS_SATURATED_14_0 = 612;
        public static final int FATTY_ACIDS_SATURATED_14_1 = 625;
        public static final int FATTY_ACIDS_SATURATED_16_0 = 613;
        public static final int FATTY_ACIDS_SATURATED_16_1 = 626;
        public static final int FATTY_ACIDS_SATURATED_18_0 = 614;

    public static final int FATTY_ACIDS_MONOUNSATURATED = 645;
        public static final int FATTY_ACIDS_MONOUNSATURATED_18_1 = 617;
        public static final int FATTY_ACIDS_MONOUNSATURATED_16_1 = 626;

    public static final int FATTY_ACIDS_POLYUNSATURATED = 646;
        public static final int FATTY_ACIDS_POLYUNSATURATED_18_2 = 618;
        public static final int FATTY_ACIDS_POLYUNSATURATED_18_2_N6_CC = 665;
        public static final int FATTY_ACIDS_POLYUNSATURATED_18_3 = 619;
        public static final int FATTY_ACIDS_POLYUNSATURATED_18_3_N3_CCC = 851;
        public static final int FATTY_ACIDS_POLYUNSATURATED_18_3_N6_CCC = 685;
        public static final int FATTY_ACIDS_POLYUNSATURATED_18_4 = 627;
        public static final int FATTY_ACIDS_POLYUNSATURATED_20_1 = 628;
        public static final int FATTY_ACIDS_POLYUNSATURATED_20_3 = 689;
        public static final int FATTY_ACIDS_POLYUNSATURATED_20_4 = 620;
        public static final int FATTY_ACIDS_POLYUNSATURATED_20_3_N3 = 852;
        public static final int FATTY_ACIDS_POLYUNSATURATED_20_3_N6 = 853;
        public static final int FATTY_ACIDS_POLYUNSATURATED_EPA_22_1 = 630;

    public static final int FATTY_ACIDS_POLYUNSATURATED_EPA_20_5_N3 = 629;
    public static final int FATTY_ACIDS_POLYUNSATURATED_DPA_22_0 = 624;
    public static final int FATTY_ACIDS_POLYUNSATURATED_DPA_22_5_N3 = 631;
    public static final int FATTY_ACIDS_POLYUNSATURATED_DHA_22_6_N3 = 621;

    public static final int FATTY_ACIDS_TRANS = 605;
    public static final int FATTY_ACIDS_TRANS_MONOENOIC = 693;


    /**
     * MINERALS ---------------V
     * */
    public static final int CALCIUM = 301;
    public static final int IRON = 303;
    public static final int MAGNESIUM = 304;
    public static final int PHOSPHORUS = 305;
    public static final int POTASSIUM = 306;
    public static final int SODIUM = 307;
    public static final int ZINC = 309;
    public static final int COPPER = 312;
    public static final int FLUORIDE = 313;
    public static final int IODINE = 314;
    public static final int MANGANESE = 315;
    public static final int SELENIUM = 317;


    /**
     * VITAMINS AND OTHER COMPONENTS ---------------V
     * */

    public static final int VITAMIN_A_IU = 318;
    public static final int RETINOL = 319;
    public static final int VITAMIN_A_RAE = 320;
    public static final int VITAMIN_A_CAROTENE = 321;
    public static final int VITAMIN_A_CAROTENE_ALPHA = 322;

    public static final int VITAMIN_E = 323;
    public static final int VITAMIN_D_D2_PLUS_D3_IU = 324;
    public static final int VITAMIN_D_D2_PLUS_D3 = 328;
    public static final int CRYPTOXANTHIN_BETA = 334;
    public static final int CRYPTOXANTHIN_ALPHA = 333;
    public static final int LYCOPENE = 337;
    public static final int LUTEIN_PLUS_ZEAXANTHIN = 338;

    public static final int VITAMIN_C = 401;
    public static final int THIAMIN = 404;
    public static final int RIBOFLAVIN = 405;
    public static final int NIACIN = 406;
    public static final int PANTOTHENIC_ACID = 410;
    public static final int VITAMIN_B6 = 415;
    public static final int FOLATE = 417;
    public static final int VITAMIN_B12 = 418;
    public static final int CHOLINE = 421;
    public static final int VITAMIN_K_MENAQUINONE_4 = 428;
    public static final int VITAMIN_K_DYHIDROPHYLLOQUINONE = 429;
    public static final int VITAMIN_K_PHYLLOQUINONE = 430;

    public static final int FOLIC_ACID = 431;
    public static final int FOLATE_FOOD = 432;
    public static final int FOLATE_DFE = 435;
    public static final int BETAINE = 454;

    public static final int VITAMIN_B12_ADDED = 578;
    public static final int VITAMIN_E_ADDED = 1242;


    public static List<String> getListOfDataTypes(SearchDataType... searchedTypes){
        List<String> searchedDataTypes = new ArrayList<>();
        for (SearchDataType searchDataType : searchedTypes){
            switch (searchDataType){
                case FOUNDATION:
                    searchedDataTypes.add(USDA_SEARCH_QUERY_PARAM_DATA_TYPE_FOUNDATION);
                    break;
                case SR_LEGACY:
                    searchedDataTypes.add(USDA_SEARCH_QUERY_PARAM_DATA_TYPE_SR_LEGACY);
                    break;
                case SURVEY_FNDDS:
                    searchedDataTypes.add(USDA_SEARCH_QUERY_PARAM_DATA_TYPE_SURVEY_FNDDS);
                    break;
                case BRANDED:
                    searchedDataTypes.add(USDA_LIST_QUERY_PARAM_DATA_TYPE_BRANDED);
                    break;
            }
        }
        return searchedDataTypes;
    }

    public static int getNutrientCategoryNumber(int nutrientNumber) {
        Timber.d("(polarizat) ---> UsdaUtils ----> getNutrientCategoryNumber: nutrientNumber is " + nutrientNumber);
        switch (nutrientNumber) {

        /* PROXIMATES */
            case SUGARS_TOTAL_INCLUDING_NLEA:
            case FATTY_ACIDS_MONOUNSATURATED:
            case FATTY_ACIDS_POLYUNSATURATED:
            case FATTY_ACIDS_SATURATED:
            case WATER:
            case DIETARY_FIBERS:
            case THEBROMINE:
                return CATEGORY_PROXIMATES;

        /* PROXIMATES - CARBS*/
            case SUCROSE:
            case GLUCOSE_DEXTROSE:
            case FRUCTOSE:
            case LACTOSE:
            case MALTOSE:
            case GALACTOSE:
            case STARCH:
                return SUBCATEGORY_PROXIMATES_CARBOHYDRATES;

        /* MINERALS */
            case CALCIUM:
            case IRON:
            case MAGNESIUM:
            case PHOSPHORUS:
            case POTASSIUM:
            case SODIUM:
            case ZINC:
            case COPPER:
            case FLUORIDE:
            case IODINE:
            case MANGANESE:
            case SELENIUM:
                return CATEGORY_MINERALS;

        /* VITAMINS */
            case CHOLINE:
            case FOLATE:
            case NIACIN:
            case PANTOTHENIC_ACID:
            case RIBOFLAVIN:
            case VITAMIN_B6:
            case VITAMIN_B12:
            case VITAMIN_C:
            case VITAMIN_D_D2_PLUS_D3:
            case VITAMIN_E:
            case THIAMIN:
            case VITAMIN_K_MENAQUINONE_4:
            case VITAMIN_K_DYHIDROPHYLLOQUINONE:
            case VITAMIN_K_PHYLLOQUINONE:
                return CATEGORY_VITAMINS_AND_OTHER_COMPONENTS;

        /* PHYTONUTRIENTS */
            case CRYPTOXANTHIN_BETA:
            case LUTEIN_PLUS_ZEAXANTHIN:
            case LYCOPENE:
                return CATEGORY_PHYTONUTRIENTS;

        /* MISCELLANEOUS */
            case CAFFEINE:
            case ALCOHOL_ETHYL:
            case CHOLESTEROL:
            case FATTY_ACIDS_POLYUNSATURATED_EPA_20_5_N3:
            case LEUCINE:
                return CATEGORY_MISCELLANEOUS;


            default:
                return 0;
        }
    }



}
