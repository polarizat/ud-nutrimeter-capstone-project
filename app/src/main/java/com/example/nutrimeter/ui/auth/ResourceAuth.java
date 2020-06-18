package com.example.nutrimeter.ui.auth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.nutrimeter.common.Resource;

public class ResourceAuth<T> {

    @NonNull
    public final Status status;

    @Nullable
    public final T data;

    @Nullable
    public final String message;


    public ResourceAuth(@NonNull ResourceAuth.Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public ResourceAuth(String message){
        this.status = Status.DEFAULT;
        this.data = null;
        this.message = message;
    }


    public static <T> Resource<T> success (@Nullable T data) {
        return new Resource<>(Resource.Status.SUCCESS, data, null);
    }

    public static <T> Resource<T> error(@NonNull String msg, @Nullable T data) {
        return new Resource<>(Resource.Status.ERROR, data, msg);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(Resource.Status.LOADING, data, null);
    }

    public enum Status { SUCCESS, SUCCESS_NEED_CONFIG, ERROR, LOADING, DEFAULT}
}
