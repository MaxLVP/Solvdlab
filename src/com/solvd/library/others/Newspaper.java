package com.solvd.library.others;

import com.solvd.library.MyLogger;

public class Newspaper extends Periodicals implements IReading, Comparable<Newspaper>{
    static final MyLogger logger = MyLogger.getInstance();
    private final int ID;

    static {
        String typeName = "Газета";
        System.out.println("Получена " + typeName);
    }

    public Newspaper(int id, String name, String genre) {
        super(genre, name);
        this.ID = id;
    }

    public int getId() {
        return ID;
    }

    @Override
    public int compareTo(Newspaper news) {
        int anotherId = news.getId();
        return this.ID - anotherId;
    }

    @Override
    public void returnPeriodicals() {
        logger.info(this.getName() + " возвращена");
    }

    @Override
    public String toString() {
        return "Газета '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }


}
