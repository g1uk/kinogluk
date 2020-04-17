package com.lisovskiy.kinogluk.exceptions;

public class GameOfReleaseYearNotFoundException extends RuntimeException {

    public GameOfReleaseYearNotFoundException (String from, String to) {
        super("Games in diapason of these dates: " + from + " and " + to + " not found.");
    }

}
