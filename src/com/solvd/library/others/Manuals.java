package com.solvd.library.others;

public class Manuals extends Papers {

    public Manuals(String name, String genre) {
        super(genre, name);
    }

    @Override
    public String toString() {
        return "Методичка '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }
}
