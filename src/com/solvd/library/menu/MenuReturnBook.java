package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.books.Book;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.GenreNotFoundException;
import com.solvd.library.library.Adding;

public class MenuReturnBook {
    static final MyLogger logger = MyLogger.getInstance();

    public static void returnBook(Card card) throws GenreNotFoundException {
        Book books = new Adding().returnAndTakeBook(card);
        if (books == null) {
            logger.info("Пользователю " + card.getVisitor().getName() + " ничего не выдано");
        } else {
            logger.info("Взята " + books);
        }
        logger.info(card);
    }
}
