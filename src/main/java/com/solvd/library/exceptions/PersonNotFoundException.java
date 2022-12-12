package com.solvd.library.exceptions;

public class PersonNotFoundException extends Exception{
    private final static String MESSAGE = "Такой пользователь не найден";

    public PersonNotFoundException() {
        super(MESSAGE);
    }
}
