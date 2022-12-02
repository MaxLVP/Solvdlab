package com.solvd.library.others;

public class Manuals extends Periodicals implements IReading{
    static {
        String typeName = "Методичка";
        System.out.println("Получена " + typeName);
    }

    public Manuals(String name, String genre) {
        super(genre, name);
    }

    @Override
    public void returnPeriodicals() {
        System.out.println(this.getName() + " возвращена");
    }

    @Override
    public String toString() {
        return "Методичка '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }
}
