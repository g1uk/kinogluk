package com.lisovskiy.kinogluk.exceptions;

public class GameWithRatingNotFoundException extends RuntimeException {

    public GameWithRatingNotFoundException (int from, int to) {
        super("Games in rating diapason: " + from + "-" + to + " not found.");
    }

}
