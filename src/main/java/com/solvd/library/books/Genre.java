package com.solvd.library.books;

import com.solvd.library.exceptions.GenreNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public enum Genre {
    DETECTIVE("детектив"),
    ADVENTURE("приключения"),
    FANTASTIC("фантастика"),
    FANTASY("фэнтэзи"),
    HORROR("ужасы");

    private final String GENRE;

    Genre(String genre) {
        this.GENRE = genre;
    }

    public String getGenre() {
        return GENRE;
    }

    public static Genre getGenreFromString(String genre) throws GenreNotFoundException {
        Optional<Genre> genreForValue = Arrays.stream(Genre.values()).filter(gen -> gen.getGenre().equals(genre)).findFirst();
        if (genreForValue.isPresent()) {
            return genreForValue.get();
        } else {
            throw new GenreNotFoundException();
        }
    }

    public static Genre chooseRandomGenre() {
        Random random = new Random();
        List<Genre> randomGenre = Arrays.stream(Genre.values()).toList();
        return randomGenre.get(random.nextInt(randomGenre.size()));
    }
}
