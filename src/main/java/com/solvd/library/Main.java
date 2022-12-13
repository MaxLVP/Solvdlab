package com.solvd.library;

import com.solvd.library.authentificaation.Auth;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.GenreNotFoundException;
import com.solvd.library.exceptions.PeriodicalNotFoundException;

import static com.solvd.library.library.FillInLibrary.fillInLibrary;
import static com.solvd.library.menu.Menu.menu;
import static com.solvd.library.utils.FileReadAndWriteUtil.readAndWriteFile;

public class Main {
    static final MyLogger logger = MyLogger.getInstance();

    public static void main(String[] args) throws GenreNotFoundException, PeriodicalNotFoundException {
        fillInLibrary();
        readAndWriteFile();
        logger.info("Добро пожаловать");
        Card card = new Auth().auth();
        logger.info("В систему вошел пользователь: " + card.getVisitor());
        logger.info(card);
        while (!menu(card, false)) {
            menu(card, false);
        }
        logger.info("Выход из программы");
    }
}