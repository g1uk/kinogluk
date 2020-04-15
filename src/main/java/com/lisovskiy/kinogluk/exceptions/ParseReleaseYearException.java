package com.lisovskiy.kinogluk.exceptions;

public class ParseReleaseYearException extends RuntimeException {

    public ParseReleaseYearException (String from, String to) {
        super("Unable to parse those strings: " + from + " " + to);
    }
}
