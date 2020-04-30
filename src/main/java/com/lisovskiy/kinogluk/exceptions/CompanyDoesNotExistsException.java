package com.lisovskiy.kinogluk.exceptions;

public class CompanyDoesNotExistsException extends RuntimeException {

    public CompanyDoesNotExistsException (int id) {
        super("Company with this id \"" + id + "\" does not exist");
    }

    public CompanyDoesNotExistsException (String title) {
        super("Company with this title \"" + title + "\" does not exist.");
    }

}
