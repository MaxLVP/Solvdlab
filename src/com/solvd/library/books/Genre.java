package com.solvd.library.books;

public enum Genre {
    Detective("детектив"),
    Adventure("приключения"),
    Fantastic("фантастика"),
    Fantasy("фэнтэзи"),
    Horror("ужасы"),
    Science("наука");

    private final String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}
