package com.lisovskiy.kinogluk;

public class GameIdMismatchException extends RuntimeException {
    public GameIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameIdMismatchException() {

    }
}
