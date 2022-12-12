package com.solvd.library.exceptions;

public class PersonBooksNotFound extends Exception{
    private final static String MESSAGE = "У вас нет взятых книг";

    public PersonBooksNotFound() {
        super(MESSAGE);
    }
}
