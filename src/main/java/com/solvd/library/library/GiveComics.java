package com.solvd.library.library;

import com.solvd.library.books.Genre;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.GenreNotFoundException;
import com.solvd.library.others.Comics;

import static com.solvd.library.storage.ComicsFactory.chooseComics;

public class GiveComics {

    public static Comics chooseComicsForVisitor(Card card) throws GenreNotFoundException {
        String info = card.getVisitor().getGenre();
        Comics com;
        switch (info) {
            case "детектив" -> {
                com = chooseComics(Genre.DETECTIVE);
                card.setComics(com);
                return com;
            }
            case "фэнтэзи" -> {
                com = chooseComics(Genre.FANTASY);
                card.setComics(com);
                return com;
            }
            case "ужасы" -> {
                com = chooseComics(Genre.HORROR);
                card.setComics(com);
                return com;
            }
            case "приключения" -> {
                com = chooseComics(Genre.ADVENTURE);
                card.setComics(com);
                return com;
            }
            case "фантастика" -> {
                com = chooseComics(Genre.FANTASTIC);
                card.setComics(com);
                return com;
            }
            default -> throw new GenreNotFoundException();
        }
    }
}

