package com.lisovskiy.kinogluk.exceptions;

public class GameIsAlreadyExistsException extends RuntimeException {

    public GameIsAlreadyExistsException(String title) {
        super("This game: \"" + title + "\" is already exist in the library.");
    }

}
