package com.solvd.library.menu;

import com.solvd.library.books.Book;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.GenreNotFoundException;
import com.solvd.library.library.Suggestion;
import org.apache.logging.log4j.Logger;

public class MenuTakeBook {

    public static void takeBook(Card card, Logger logger) throws GenreNotFoundException {
        Book book = new Suggestion().suggest(card, logger);
        if (book == null) {
            logger.info("Пользователю " + card.getVisitor().getName() + " ничего не выдано");
        } else {
            logger.info("Взята " + book);
        }
        logger.info(card);
    }
}
