package com.lisovskiy.kinogluk.exceptions;

public class CatalogDoesNotExistsException extends RuntimeException {

    public CatalogDoesNotExistsException (int id) {
        super("Catalog with this id \"" + id + "\" does not exist.");
    }

    public CatalogDoesNotExistsException (String title) {
        super("Catalog with this title \"" + title + "\" does not exist.");
    }

}
