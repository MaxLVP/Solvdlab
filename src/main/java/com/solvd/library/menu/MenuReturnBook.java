package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.books.Book;
import com.solvd.library.cards.Card;
import com.solvd.library.library.Returning;

public class MenuReturnBook {
    static final MyLogger LOGGER = MyLogger.getInstance();

    public static void returnBook(Card card) {
        Book books = new Returning().returnAndTakeBook(card);
        if (books == null) {
            LOGGER.info("Пользователю " + card.getVisitor().getName() + " ничего не выдано");
        } else {
            LOGGER.info("Взята " + books);
        }
        LOGGER.info(card);
    }
}
