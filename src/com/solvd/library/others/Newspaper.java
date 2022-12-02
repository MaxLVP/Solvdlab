package com.solvd.library.others;

public class Newspaper extends Periodicals implements IReading{
    static {
        String typeName = "Газета";
        System.out.println("Получена " + typeName);
    }

    public Newspaper(String name, String genre) {
        super(genre, name);
    }

    @Override
    public void returnPeriodicals() {
        System.out.println(this.getName() + " возвращена");
    }

    @Override
    public String toString() {
        return "Газета '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }
}
