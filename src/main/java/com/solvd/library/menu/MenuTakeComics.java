package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.cards.Card;
import com.solvd.library.others.Comics;

import static com.solvd.library.library.GiveComics.chooseComicsForVisitor;
import static com.solvd.library.storage.ComicsFactory.addComics;


public class MenuTakeComics {
    static final MyLogger LOGGER = MyLogger.getInstance();

    public static Comics takeComics(Card card) {
        Comics comic = card.getComics();
        if (comic != null ) {
            LOGGER.info("У вас не сдан комикс");
            LOGGER.info("Возвращаен комикс" + comic);
            addComics(comic);
        }
        Comics comics = chooseComicsForVisitor(card);
        LOGGER.info(card);
        return comics;
    }
}
