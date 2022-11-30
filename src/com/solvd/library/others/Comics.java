package com.solvd.library.others;

public class Comics extends Periodicals implements IReading {

    public Comics(String name, String genre) {
        super(genre, name);
    }

    @Override
    public void returnPeriodicals() {
        System.out.println("Комикс " + this.getName() + " возвращен");
    }

    @Override
    public String toString() {
        return "Комикс '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }
}
