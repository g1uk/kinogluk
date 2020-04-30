package com.lisovskiy.kinogluk.exceptions;

public class CatalogIsAlreadyExistsException extends RuntimeException {

    public CatalogIsAlreadyExistsException(String title) {
        super("This catalog: \"" + title + "\" is already exist in the library.");
    }

}
