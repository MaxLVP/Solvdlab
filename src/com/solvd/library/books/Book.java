package com.solvd.library.books;

import java.util.Objects;

public abstract class Book {
    private String name;
    private String author;
    private int pages;

    public Book(String name, String author, int pages) {
        this.name = name;
        this.author = author;
        this.pages = pages;
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

    public abstract void readBook();

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
