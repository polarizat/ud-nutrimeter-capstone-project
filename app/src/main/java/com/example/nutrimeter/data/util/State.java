package com.example.nutrimeter.data.util;

public class State {
    public enum AuthState {
        UNAUTHENTICATED,        // Initial state, the user needs to authenticate
        AUTHENTICATED,          // The user has authenticated successfully
        AUTHENTICATED_GOOGLE,          // The user has authenticated successfully
        INVALID_AUTHENTICATION,  // Authentication failed // Authentication failed
    }
}
