package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.GenreNotFoundException;
import com.solvd.library.others.Comics;

import static com.solvd.library.library.GiveComics.chooseComicsForVisitor;
import static com.solvd.library.storage.ComicsFactory.addComics;


public class MenuTakeComics {
    static final MyLogger logger = MyLogger.getInstance();

    public static Comics takeComics(Card card) throws GenreNotFoundException {
        Comics comic = card.getComics();
        if (comic != null ) {
            logger.info("У вас не сдан комикс");
            logger.info("Возвращаен комикс" + comic);
            addComics(comic);
        }
        Comics comics = chooseComicsForVisitor(card);
        logger.info(card);
        return comics;
    }
}
