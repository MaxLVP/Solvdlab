package com.solvd.library.others;

public class Manuals extends Periodicals implements IReading{

    public Manuals(String name, String genre) {
        super(genre, name);
    }

    @Override
    public void returnPeriodicals() {
        System.out.println("Методичка " + this.getName() + " возвращена");
    }

    @Override
    public String toString() {
        return "Методичка '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }
}
