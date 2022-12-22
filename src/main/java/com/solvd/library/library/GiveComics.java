package com.solvd.library.library;

import com.solvd.library.MyLogger;
import com.solvd.library.cards.Card;
import com.solvd.library.others.Comics;

import static com.solvd.library.storage.ComicsFactory.chooseComics;

public class GiveComics {
    static final MyLogger LOGGER = MyLogger.getInstance();

    public static Comics chooseComicsForVisitor(Card card) {
        Comics com = chooseComics(card.getVisitor().getGenre());
        LOGGER.info("Взят комикс: " + com);
        card.setComics(com);
        return com;
    }
}

