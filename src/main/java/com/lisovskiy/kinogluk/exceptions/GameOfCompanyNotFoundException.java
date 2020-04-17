package com.lisovskiy.kinogluk.exceptions;

import com.lisovskiy.kinogluk.entity.Company;

public class GameOfCompanyNotFoundException extends RuntimeException {

    public GameOfCompanyNotFoundException (Company company) {
        super("Games of " + company.getTitle() + " company not found.");
    }

}
