package com.solvd.library.exceptions;

public class PeriodicalNotFoundException extends Exception{
    private final static String MESSAGE = "Такой переодики не существует";

    public PeriodicalNotFoundException() {
        super(MESSAGE);
    }
}
