package com.solvd.library.library;

import com.solvd.library.MyLogger;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.PeriodicalNotFoundException;
import com.solvd.library.others.*;

import java.util.Scanner;

import static com.solvd.library.library.ReturnPeriodicals.returnPeriodical;
import static com.solvd.library.storage.MagazinesFactory.getMagazine;
import static com.solvd.library.storage.NewsFactory.getNews;

public class Giveaway {
    static final MyLogger LOGGER = MyLogger.getInstance();

    public Periodicals giveaway(Card card) throws PeriodicalNotFoundException {
        if (card.getPeriodicals() != null) {
            LOGGER.info("У вас не возвращена переодика, верните предыдущую");
            returnPeriodical(card.getPeriodicals());
        }
        LOGGER.info("Что вы хотите получить? (газета, журнал)");
        Scanner scanner = new Scanner(System.in);
        String type = "";
        if (scanner.hasNextLine()) {
            type = scanner.nextLine();
        } else {
            LOGGER.warn("Вы не ввели что хотите получить");
        }
        Periodicals periodical;
        switch (type) {
            case "газета" -> periodical = giveNewspaper();
            case "журнал" -> periodical = giveMagazine();
            default -> throw new PeriodicalNotFoundException();
        }
        return periodical;
    }

    public Newspaper giveNewspaper() {
        return getNews();
    }

    public Magazine giveMagazine() {
        LOGGER.info("Введите название журнала");
        Scanner scanner = new Scanner(System.in);
        Magazine magazine = getMagazine(scanner.nextLine());
        if (magazine == null) {
            LOGGER.info("Такого журнала нет");
        }
        return magazine;
    }

}
