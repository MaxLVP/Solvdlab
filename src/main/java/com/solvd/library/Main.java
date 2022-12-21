package com.solvd.library;

import com.solvd.library.authentificaation.Auth;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.GenreNotFoundException;
import com.solvd.library.exceptions.PeriodicalNotFoundException;

import static com.solvd.library.library.FillInLibrary.fillInLibrary;
import static com.solvd.library.menu.Menu.menu;

public class Main {
    static final MyLogger logger = MyLogger.getInstance();
    private final static Auth authentication = new Auth();

    public static void main(String[] args) throws GenreNotFoundException, PeriodicalNotFoundException {
        fillInLibrary();
        logger.info("Добро пожаловать");
        Card card = authentication.auth();
        logger.info("В систему вошел пользователь: " + card.getVisitor());
        logger.info(card);
        while (!menu(card, authentication, false)) {
            menu(card, authentication, false);
        }
        logger.info("Выход из программы");
    }
}