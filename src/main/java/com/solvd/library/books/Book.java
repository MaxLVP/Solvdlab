package com.solvd.library.books;

import com.solvd.library.MyLogger;

import java.util.Objects;

public class Book {
    static final MyLogger LOGGER = MyLogger.getInstance();
    private final String NAME;
    private final String AUTHOR;
    private final int PAGES;
    private final Genre GENRE;

    public Book(String name, String author, int pages, Genre genre) {
        this.NAME = name;
        this.AUTHOR = author;
        this.PAGES = pages;
        this.GENRE = genre;
    }

    public String getName() {
        return NAME;
    }

    public String getAuthor() {
        return AUTHOR;
    }

    public int getPages() {
        return PAGES;
    }

    public Genre getGenre() {
        return GENRE;
    }

    public final void returnBook() {
        LOGGER.info("Книга " + this.NAME + " была добавлена в раздел " + GENRE.getGenre());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return PAGES == book.PAGES && Objects.equals(NAME, book.NAME) && Objects.equals(AUTHOR, book.AUTHOR);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME, AUTHOR, PAGES);
    }

    @Override
    public String toString() {
        return "Книга под названием: '" + this.getName() + '\'' +
                ", автор: '" + this.getAuthor() + '\'' +
                ", жанр: '" + GENRE.getGenre() + '\'' +
                ", количество страниц: " + this.getPages();
    }
}
