package com.solvd.library.others;

public class Magazine extends Periodicals implements IReading {
    static {
        String typeName = "Журнал";
        System.out.println("Получен " + typeName);
    }

    public Magazine(String name, String genre) {
        super(genre, name);
    }

    @Override
    public void returnPeriodicals() {
        System.out.println(this.getName() + " возвращен");
    }

    @Override
    public String toString() {
        return "Журнал '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }
}
