package com.lisovskiy.kinogluk.exceptions;

public class GenreIsAlreadyExistsException extends RuntimeException {

    public GenreIsAlreadyExistsException (String title) {
        super("This genre: \"" + title + "\" is already exist in the library");
    }

}
