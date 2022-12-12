package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.books.Book;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.GenreNotFoundException;
import com.solvd.library.library.Suggestion;

public class MenuTakeBook {
    static final MyLogger logger = MyLogger.getInstance();

    public static void takeBook(Card card) throws GenreNotFoundException {
        Book book = new Suggestion().suggest(card);
        if (book == null) {
            logger.info("Пользователю " + card.getVisitor().getName() + " ничего не выдано");
        } else {
            logger.info("Взята " + book);
        }
        logger.info(card);
    }
}
