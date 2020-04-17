package com.lisovskiy.kinogluk.exceptions;

import com.lisovskiy.kinogluk.entity.Genre;

public class GameOfGenreNotFoundException extends RuntimeException {

    public GameOfGenreNotFoundException (Genre genre) {
        super("Games of genre: " + genre  + " not found.");
    }

}
