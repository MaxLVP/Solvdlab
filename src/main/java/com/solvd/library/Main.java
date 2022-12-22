package com.solvd.library;

import com.solvd.library.authentificaation.Auth;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.GenreNotFoundException;
import com.solvd.library.exceptions.PeriodicalNotFoundException;

import static com.solvd.library.library.FillInLibrary.fillInLibrary;
import static com.solvd.library.menu.Menu.menu;

public class Main {
    static final MyLogger LOGGER = MyLogger.getInstance();
    private final static Auth AUTHENTICATION = new Auth();

    public static void main(String[] args) throws GenreNotFoundException, PeriodicalNotFoundException {
        fillInLibrary();
        LOGGER.info("Добро пожаловать");
        Card card = AUTHENTICATION.auth();
        LOGGER.info("В систему вошел пользователь: " + card.getVisitor());
        LOGGER.info(card);
        while (!menu(card, AUTHENTICATION, false)) {
            menu(card, AUTHENTICATION, false);
        }
        LOGGER.info("Выход из программы");
    }
}