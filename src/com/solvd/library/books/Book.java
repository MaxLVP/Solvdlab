package com.solvd.library.books;

import java.util.Objects;

public class Book {
    private final String name;
    private final String author;
    private final int pages;
    private final Genre genre;

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
        System.out.println("Книга " + this.name + " была прочитана.");
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
