package com.lisovskiy.kinogluk;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException (int id) {
        super("Game with id=" + id + " not found");
    }

    public NotFoundException(String title) {
        super("Game1 with title=" + title + " not found");
    }
}
