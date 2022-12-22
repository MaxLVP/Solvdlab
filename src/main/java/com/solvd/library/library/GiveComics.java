package com.solvd.library.library;

import com.solvd.library.books.Genre;
import com.solvd.library.cards.Card;
import com.solvd.library.others.Comics;

import static com.solvd.library.storage.ComicsFactory.chooseComics;
import static com.solvd.library.utils.ReturnVisitorGenreUtil.returnGenre;

public class GiveComics {

    public static Comics chooseComicsForVisitor(Card card) {
        Genre genre = returnGenre(card.getVisitor());
        Comics com = chooseComics(genre);
        card.setComics(com);
        return com;
    }
}

