package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.books.Book;
import com.solvd.library.cards.Card;
import com.solvd.library.library.Suggestion;

public class MenuTakeBook {
    static final MyLogger LOGGER = MyLogger.getInstance();

    public static void takeBook(Card card) {
        Book book = new Suggestion().suggest(card);
        if (book == null) {
            LOGGER.info("Пользователю " + card.getVisitor().getName() + " ничего не выдано");
        } else {
            LOGGER.info("Взята " + book);
        }
        LOGGER.info(card);
    }
}
