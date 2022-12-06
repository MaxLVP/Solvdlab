package com.solvd.library.others;

import com.solvd.library.MyLogger;
import com.solvd.library.books.Genre;


public class Comics implements IReading {
    static final MyLogger logger = MyLogger.getInstance();
    private String name;
    private Genre genre;

    static {
        String typeName = "Комикс";
        System.out.println("Получен " + typeName);
    }

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
    public void returnPeriodicals() {
        logger.info(this.getName() + " возвращен");
    }

    @Override
    public String toString() {
        return "Комикс '" + this.getName() + '\'' +
                " жанр '" + genre.getGenre() + '\'';
    }
}
