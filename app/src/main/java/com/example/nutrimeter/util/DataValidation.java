package com.example.nutrimeter.util;

public class DataValidation {

    public enum DataType {
        EMAIL,
        PASSWORD,
        NAME,
        WEIGHT_METRIC,
        WEIGHT_IMPERIAL,
        HEIGHT_METRIC,
        HEIGHT_IMPERIAL_FEET,
        HEIGHT_IMPERIAL_INCHES,
        AGE
    }

    public static boolean isDataValid (DataType type, String data) {
        switch (type){
            case EMAIL:
                return !data.isEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(data).matches();
            case PASSWORD:
                if (data.isEmpty()) {
                    return false;
                } else {
                    return data.length() >= 6;
                }

            case NAME:
                return !data.isEmpty();

            case WEIGHT_METRIC:
                return (data != null && !data.isEmpty() && Float.parseFloat(data) >= 20f
                                     && Float.parseFloat(data) <= 500f);

            case WEIGHT_IMPERIAL:
                return (data != null && !data.isEmpty() && Float.parseFloat(data) >= 50f
                                     && Float.parseFloat(data) <= 1000f);

            case HEIGHT_METRIC:
                return (data != null && !data.isEmpty() && Float.parseFloat(data) >= 40f
                                     && Float.parseFloat(data) <= 300f);

            case HEIGHT_IMPERIAL_FEET:
                return (data != null && !data.isEmpty() && Float.parseFloat(data) >= 1f
                                     && Float.parseFloat(data) <= 10f);

            case HEIGHT_IMPERIAL_INCHES:
                return (data != null && !data.isEmpty() && Float.parseFloat(data) >= 0f
                                     && Float.parseFloat(data) <= 12f);

            case AGE:
                return (data != null && !data.isEmpty() && Integer.parseInt(data) >= 13
                                     && Integer.parseInt(data) <= 120);

            default:
                return false;
        }
    }


}
