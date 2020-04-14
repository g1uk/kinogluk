package com.lisovskiy.kinogluk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RatingGameNotFoundException {
    public RatingGameNotFoundException (int from, int to) {
        //super("Games with this rating not found");
    }
}
