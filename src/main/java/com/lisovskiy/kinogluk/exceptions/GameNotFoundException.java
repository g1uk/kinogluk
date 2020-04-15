package com.lisovskiy.kinogluk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GameNotFoundException extends RuntimeException {

    public GameNotFoundException(int id) {
        super("Game with id =  " + id + " not found");
    }

    public GameNotFoundException(String title) {
        super("Game with title = " + title + " not found");
    }

    public GameNotFoundException(int from, int to) {

    }
    public GameNotFoundException(String from, String to) {
        super("Games between " + from + " and " + to + " not found");
    }
}
