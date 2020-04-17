package com.lisovskiy.kinogluk.exceptions;

import com.lisovskiy.kinogluk.entity.Catalog;

public class GameOfCatalogNotFoundException extends RuntimeException {

    public GameOfCatalogNotFoundException (Catalog catalog) {
        super("Games in " + catalog.getTitle() + " not found.");
    }

}
