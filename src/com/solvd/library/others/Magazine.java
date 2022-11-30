package com.solvd.library.others;

public class Magazine extends Periodicals implements IReading{

    public Magazine(String name, String genre) {
        super(genre, name);
    }

    @Override
    public void returnPeriodicals() {
        System.out.println("Журнал " + this.getName() + " возвращен");
    }

    @Override
    public String toString() {
        return "Журнал '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }
}
