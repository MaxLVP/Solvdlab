package com.solvd.library.others;

public class Comics extends Periodicals implements IReading {
    static {
        String typeName = "Комикс";
        System.out.println("Получен " + typeName);
    }

    public Comics(String name, String genre) {
        super(genre, name);
    }

    @Override
    public void returnPeriodicals() {
        System.out.println(this.getName() + " возвращен");
    }

    @Override
    public String toString() {
        return "Комикс '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }
}
