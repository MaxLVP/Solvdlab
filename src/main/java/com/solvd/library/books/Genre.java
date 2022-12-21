package com.solvd.library.books;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Genre {
    DETECTIVE("детектив"),
    ADVENTURE("приключения"),
    FANTASTIC("фантастика"),
    FANTASY("фэнтэзи"),
    HORROR("ужасы");

    private final String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public static Genre chooseRandomGenre() {
        Random random = new Random();
        List<Genre> randomGenre = Arrays.stream(Genre.values()).toList();
        return randomGenre.get(random.nextInt(randomGenre.size()));
    }
}
