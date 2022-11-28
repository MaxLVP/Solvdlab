package com.solvd.library.books;

public class Science extends Book{
    private final String genre = "Science";

    public Science(String name, String author, int pages) {
        super(name, author, pages);
    }

    public void readBook() {
        System.out.println("Научная книга была прочитана");
    }
}
