package com.solvd.library.books;

public class Adventure extends Book{
    private final String genre = "Adventure";

    public Adventure(String name, String author, int pages) {
        super(name, author, pages);
    }

    public void readBook() {
        System.out.println("Книга про приключения была прочитана");
    }
}
