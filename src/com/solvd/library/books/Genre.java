package com.solvd.library.books;

public enum Genre {
    DETECTIVE("детектив"),
    ADVENTURE("приключения"),
    FANTASTIC("фантастика"),
    FANTASY("фэнтэзи"),
    HORROR("ужасы"),
    SCIENCE("наука");

    private final String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}
