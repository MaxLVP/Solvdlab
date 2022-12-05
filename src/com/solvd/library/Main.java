package com.solvd.library;

import com.solvd.library.authentificaation.Auth;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.GenreNotFoundException;
import com.solvd.library.exceptions.PeriodicalNotFoundException;

import static com.solvd.library.menu.Menu.menu;
import static com.solvd.library.storage.BooksFactory.fillInStorage;

public class Main {
    static final MyLogger logger = MyLogger.getInstance();

    public static void main(String[] args) throws GenreNotFoundException, PeriodicalNotFoundException {
        fillInStorage();
        logger.info("Добро пожаловать");
        Card card = new Auth().auth();
        logger.info("В систему вошел пользователь: " + card.getVisitor());
        logger.info(card);
        boolean exit = false;
        while (!exit) {
            exit = menu(card, false);
        }
        logger.info("Выход из программы");
    }
}