package com.solvd.library.exceptions;

public class LibraryBooksNotFound extends Exception{
    private final static String MESSAGE = "Книг данного жанра нет в библиотеке";

    public LibraryBooksNotFound() {
        super(MESSAGE);
    }
}
