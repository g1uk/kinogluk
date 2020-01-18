package com.lisovskiy.kinogluk;

public class GameNotFoundException extends RuntimeException {

    public GameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public GameNotFoundException () {}
}
