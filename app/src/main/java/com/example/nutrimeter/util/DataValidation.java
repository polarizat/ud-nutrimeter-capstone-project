package com.example.nutrimeter.util;

import com.example.nutrimeter.R;

public class DataValidation {

    public static boolean isDataValid (DataType type, String data) {
        switch (type){
            case EMAIL:
                if (data.isEmpty()) {
                    //TODO
                    return false;
                } else {
                    if (!android.util.Patterns.EMAIL_ADDRESS.matcher(data).matches()) {
                        //TODO
                        return false;
                    } else {
                        //TODO
                        return true;
                    }
                }
            case PASSWORD:
                if (data.isEmpty()) {
                    //            passwordLayout.setError(getString(R.string.sign_in_error_password_empty));
                    return false;
                } else {
                    if (data.length() < 6) {
                        //                passwordLayout.setError(getString(R.string.sign_in_error_password_invalid));
                        return false;
                    } else {
                        //                passwordLayout.setError(null);
                        return true;
                    }
                }

            case NAME:
                if (data.isEmpty()){
                    //             nameLayout.setError(getString(R.string.sign_in_error_name_empty));
                    return false;
                } else {
                    //            nameLayout.setError(null);
                    return  true;
                }
            default:
                return false;
        }
    }



    public enum DataType { EMAIL, PASSWORD, NAME}
}
