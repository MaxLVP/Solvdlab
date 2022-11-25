package com.solvd.library.others;

public class Magazine extends Papers {

    public Magazine(String name, String genre) {
        super(genre, name);
    }

    @Override
    public String toString() {
        return "Журнал '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }
}
