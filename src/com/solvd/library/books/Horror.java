package com.solvd.library.books;

public class Horror extends Book{
    private final String genre = "Horror";

    public Horror(String name, String author, int pages) {
        super(name, author, pages);
    }

    public void readBook() {
        System.out.println("Книга ужасов была прочитана");
    }
}
