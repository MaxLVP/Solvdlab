package com.solvd.library.books;

public class Detective extends Book{
    private final String genre = "Detective";

    public Detective(String name, String author, int pages) {
        super(name, author, pages);
    }

    public void readBook() {
        System.out.println("Детективная книга была прочитана");
    }
}
