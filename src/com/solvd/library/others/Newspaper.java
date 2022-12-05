package com.solvd.library.others;

import com.solvd.library.MyLogger;

public class Newspaper extends Periodicals implements IReading{
    static final MyLogger logger = MyLogger.getInstance();

    static {
        String typeName = "Газета";
        System.out.println("Получена " + typeName);
    }

    public Newspaper(String name, String genre) {
        super(genre, name);
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
