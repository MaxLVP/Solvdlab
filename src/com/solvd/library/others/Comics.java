package com.solvd.library.others;

public class Comics extends Papers implements IReading {

    public Comics(String name, String genre) {
        super(genre, name);
    }

    @Override
    public void read() {
        System.out.println("Журнал прочитан");
    }

    @Override
    public String toString() {
        return "Комикс '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }
}
