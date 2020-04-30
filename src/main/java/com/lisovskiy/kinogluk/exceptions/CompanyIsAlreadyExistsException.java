package com.lisovskiy.kinogluk.exceptions;

public class CompanyIsAlreadyExistsException extends RuntimeException {

    public CompanyIsAlreadyExistsException (String title) {
        super("This company: \"" + title + "\" is already exist in the library.");
    }

}
