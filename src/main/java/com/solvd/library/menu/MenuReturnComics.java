package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.cards.Card;
import com.solvd.library.others.Comics;

import static com.solvd.library.storage.ComicsFactory.addComics;

public class MenuReturnComics {
    static final MyLogger logger = MyLogger.getInstance();

    public static void returnComics(Card card) {
        Comics comic = card.getComics();
        if (comic != null ) {
            logger.info("Возвращаен комикс" + comic);
            addComics(comic);
        }
    }
}
