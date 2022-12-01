package com.solvd.library.books;

import java.util.Objects;

public class Book {
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

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public final void readBook() {
        System.out.println("Книга " + this.name + " была прочитана.");
    };

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
        return "Книга под названием: '" + name + '\'' +
                ", автор: '" + author + '\'' ;
    }
}
