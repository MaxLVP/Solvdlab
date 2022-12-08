package com.solvd.library.others;

import com.solvd.library.MyLogger;

public class Magazine extends Periodicals implements IReading {
    static final MyLogger logger = MyLogger.getInstance();

    static {
        String typeName = "Журнал";
        logger.info("Получен " + typeName);
    }

    public Magazine(String name, String genre) {
        super(genre, name);
    }

    @Override
    public void returnPeriodicals() {
        logger.info(this.getName() + " возвращен");
    }

    @Override
    public String toString() {
        return "Журнал '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }
}
