package com.solvd.library.books;

public class Fantastic extends Book{
    private final String genre = "Fantastic";

    public Fantastic(String name, String author, int pages) {
        super(name, author, pages);
    }

    public void readBook() {
        System.out.println("Книга про фантастику была прочитана");
    }
}
