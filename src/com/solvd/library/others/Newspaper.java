package com.solvd.library.others;

public class Newspaper extends Papers implements IReading{

    public Newspaper(String name, String genre) {
        super(genre, name);
    }

    @Override
    public void read() {
        System.out.println("Журнал прочитан");
    }

    @Override
    public String toString() {
        return "Газета '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }
}
