package com.solvd.library.others;

public class Newspaper extends Periodicals implements IReading{

    public Newspaper(String name, String genre) {
        super(genre, name);
    }

    @Override
    public void returnPeriodicals() {
        System.out.println("Газета " + this.getName() + " возвращена");
    }

    @Override
    public String toString() {
        return "Газета '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }
}
