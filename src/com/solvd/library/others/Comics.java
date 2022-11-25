package com.solvd.library.others;

public class Comics extends Papers {

    public Comics(String name, String genre) {
        super(genre, name);
    }

    @Override
    public String toString() {
        return "Комикс '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }
}
