package com.solvd.library.others;

import com.solvd.library.books.Genre;


public class Comics implements Comparable<Comics>{
    private String name;
    private Genre genre;

    public Comics(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Комикс '" + this.getName() + '\'' +
                " жанр '" + genre.getGenre() + '\'';
    }

    @Override
    public int compareTo(Comics comics) {
        return this.genre.compareTo(comics.getGenre());
    }
}
