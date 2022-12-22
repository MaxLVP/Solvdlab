package com.solvd.library.library;

import com.solvd.library.MyLogger;
import com.solvd.library.others.Magazine;
import com.solvd.library.others.Newspaper;
import com.solvd.library.others.Periodicals;

import static com.solvd.library.storage.MagazinesFactory.addMagazine;
import static com.solvd.library.storage.NewsFactory.addNews;

public class ReturnPeriodicals {
    static final MyLogger LOGGER = MyLogger.getInstance();

    public static void returnPeriodical(Periodicals per) {
        if (per instanceof Newspaper) {
            LOGGER.info("Газета возвращена");
            addNews((Newspaper) per);
        } else if (per instanceof Magazine) {
            LOGGER.info("Журнал возвращен");
            addMagazine((Magazine) per);
        }
    }
}
