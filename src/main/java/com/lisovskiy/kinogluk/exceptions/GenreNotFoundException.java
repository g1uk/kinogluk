package com.lisovskiy.kinogluk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GenreNotFoundException extends RuntimeException {
    public GenreNotFoundException(int id) {
        super("Genre with id =  " + id + " not found");
    }

    public GenreNotFoundException(String title) {
        super("Genre with title = " + title + " not found");
    }
}
