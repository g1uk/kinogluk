package com.lisovskiy.kinogluk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CatalogNotFoundException extends RuntimeException {
    public CatalogNotFoundException(int id) {
        super("Catalog with id =  " + id + " not found");
    }

    public CatalogNotFoundException(String title) {
        super("Catalog with title = " + title + " not found");
    }
}
