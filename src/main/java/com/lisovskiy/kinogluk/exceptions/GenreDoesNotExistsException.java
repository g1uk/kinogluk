package com.lisovskiy.kinogluk.exceptions;

public class GenreDoesNotExistsException extends RuntimeException {

    public GenreDoesNotExistsException (int id) {
        super("Genre with id \"" + id + "\" does not exist.");
    }

    public GenreDoesNotExistsException (String title) {
        super("Genre with title \"" + title + "\" does not exist.");
    }

}
