package com.solvd.library.library;

import com.solvd.library.exceptions.PeriodicalNotFoundException;
import com.solvd.library.others.*;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Giveaway {

    public Periodicals giveaway(Logger logger) throws PeriodicalNotFoundException {
        logger.info("Что вы хотите получить? (газета, комикс, журнал, методичка)");
        Scanner scanner = new Scanner(System.in);
        String type = "";
        if (scanner.hasNextLine()) {
            type = scanner.nextLine();
        } else {
            logger.warn("Вы не ввели что хотите получить");
        }
        Periodicals periodical;
        switch (type) {
            case "газета" -> periodical = giveNewspaper(logger);
            case "методичка" -> periodical = giveManual(logger);
            case "комикс" -> periodical = giveComics(logger);
            case "журнал" -> periodical = giveMagazine(logger);
            default -> throw new PeriodicalNotFoundException();
        }
        return periodical;
    }

    public ArrayList<String> getInfo(Logger logger) {
        logger.info("Введите название и жанр");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> info = new ArrayList<>();
        String current = scanner.nextLine();
        while (!current.equals("")) {
            info.add(current);
            current = scanner.nextLine();
        }
        return info;
    }

    public Newspaper giveNewspaper(Logger logger) {
        ArrayList<String> info = getInfo(logger);
        return new Newspaper(info.get(0), info.get(1));
    }

    public Comics giveComics(Logger logger) {
        ArrayList<String> info = getInfo(logger);
        return new Comics(info.get(0), info.get(1));
    }

    public Magazine giveMagazine(Logger logger) {
        ArrayList<String> info = getInfo(logger);
        return new Magazine(info.get(0), info.get(1));
    }

    public Manuals giveManual(Logger logger) {
        ArrayList<String> info = getInfo(logger);
        return new Manuals(info.get(0), info.get(1));
    }
}
