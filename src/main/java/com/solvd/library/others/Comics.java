package com.solvd.library.others;

import com.solvd.library.MyLogger;
import com.solvd.library.books.Genre;


public class Comics {
    static final MyLogger logger = MyLogger.getInstance();
    private String name;
    private Genre genre;

    static {
        String typeName = "Комикс";
        logger.info("Получен " + typeName);
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
    public String toString() {
        return "Комикс '" + this.getName() + '\'' +
                " жанр '" + genre.getGenre() + '\'';
    }
}
