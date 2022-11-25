package com.solvd.library.others;

public class Newspaper extends Papers {

    public Newspaper(String name, String genre) {
        super(genre, name);
    }

    @Override
    public String toString() {
        return "Газета '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }
}
