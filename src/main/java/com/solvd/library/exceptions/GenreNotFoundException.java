package com.solvd.library.exceptions;

public class GenreNotFoundException extends Exception{
    private final static String MESSAGE = "Выбран неверный жанр";

    public GenreNotFoundException() {
        super(MESSAGE);
    }
}
