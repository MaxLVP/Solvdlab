package com.solvd.library.menu;

import com.solvd.library.books.Book;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.GenreNotFoundException;
import com.solvd.library.library.Adding;
import org.apache.logging.log4j.Logger;

public class MenuReturnBook {

    public static void returnBook(Card card, Logger logger) throws GenreNotFoundException {
        Book books = new Adding().returnAndTakeBook(card, logger);
        if (books == null) {
            logger.info("Пользователю " + card.getVisitor().getName() + " ничего не выдано");
        } else {
            logger.info("Взята " + books);
        }
        logger.info(card);
    }
}
