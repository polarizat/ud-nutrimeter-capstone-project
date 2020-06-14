package com.example.nutrimeter.util;

import java.util.ArrayList;
import java.util.List;

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


}
