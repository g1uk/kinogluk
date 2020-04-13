package com.lisovskiy.kinogluk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException(int id) {
        super("Company with id =  " + id + " not found");
    }

    public CompanyNotFoundException(String title) {
        super("Company with title = " + title + " not found");
    }
}
