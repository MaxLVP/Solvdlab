package com.solvd.library.others;

import com.solvd.library.MyLogger;

public class Comics extends Periodicals implements IReading {
    static final MyLogger logger = MyLogger.getInstance();

    static {
        String typeName = "Комикс";
        System.out.println("Получен " + typeName);
    }

    public Comics(String name, String genre) {
        super(genre, name);
    }

    @Override
    public void returnPeriodicals() {
        logger.info(this.getName() + " возвращен");
    }

    @Override
    public String toString() {
        return "Комикс '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }
}
