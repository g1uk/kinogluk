package com.lisovskiy.kinogluk.exceptions;

public class GameDoesNotExistsException extends RuntimeException {

    public GameDoesNotExistsException (int id) {
        super("Game with this id \"" + id + "\" does not exist");
    }

    public GameDoesNotExistsException (String title) {
        super("Game with this title \"" + title + "\" does not exist.");
    }

}
