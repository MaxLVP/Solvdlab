package com.solvd.library.others;

import com.solvd.library.MyLogger;

public class Manuals extends Periodicals implements IReading{
    static final MyLogger logger = MyLogger.getInstance();

    static {
        String typeName = "Методичка";
        logger.info("Получена " + typeName);
    }

    public Manuals(String name, String genre) {
        super(genre, name);
    }

    @Override
    public void returnPeriodicals(Periodicals periodicals) {
        logger.info(this.getName() + " возвращена");
    }

    @Override
    public String toString() {
        return "Методичка '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }
}
