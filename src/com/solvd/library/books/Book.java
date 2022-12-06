package com.solvd.library.books;

import com.solvd.library.MyLogger;

import java.util.Objects;

public class Book {
    static final MyLogger logger = MyLogger.getInstance();
    private String name;
    private String author;
    private int pages;
    private Genre genre;

    public Book(String name, String author, int pages, Genre genre) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public final void readBook() {
        logger.info("Книга " + this.name + " была прочитана.");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages && Objects.equals(name, book.name) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, pages);
    }

    @Override
    public String toString() {
        return "Книга под названием: '" + this.getName() + '\'' +
                ", автор: '" + this.getAuthor() + '\'' +
                ", жанр: '" + genre.getGenre() + '\'' +
                ", количество страниц: " + this.getPages();
    }
}
