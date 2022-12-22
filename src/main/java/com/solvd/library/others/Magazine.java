package com.solvd.library.others;

import com.solvd.library.MyLogger;

import static com.solvd.library.storage.MagazinesFactory.addMagazine;

public class Magazine extends Periodicals implements IReading {
    static final MyLogger LOGGER = MyLogger.getInstance();

    public Magazine(String name, String genre) {
        super(genre, name);
    }

    @Override
    public void returnPeriodicals(Periodicals periodicals) {
        addMagazine((Magazine) periodicals);
        LOGGER.info(this.getName() + " возвращен");
    }

    @Override
    public String toString() {
        return "Журнал '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }
}
