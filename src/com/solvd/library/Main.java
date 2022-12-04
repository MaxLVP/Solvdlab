package com.solvd.library;

import com.solvd.library.authentificaation.Auth;
import com.solvd.library.cards.Card;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.solvd.library.menu.Menu.menu;
import static com.solvd.library.storage.BooksFactory.fillInStorage;

public class Main {
    static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        fillInStorage();
        logger.warn("error");
        Card card = new Auth().auth();
        System.out.println("В систему вошел пользователь: " + card.getVisitor());
        System.out.println(card);
        boolean exit = false;
        while (!exit) {
            exit = menu(card, false);
        }
        System.out.println("Выход из программы");
    }
}