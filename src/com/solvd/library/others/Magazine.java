package com.solvd.library.others;

public class Magazine extends Papers implements IReading{

    public Magazine(String name, String genre) {
        super(genre, name);
    }

    @Override
    public void read() {
        System.out.println("Журнал прочитан");
    }

    @Override
    public String toString() {
        return "Журнал '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }
}
