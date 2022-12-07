package com.solvd.library.storage;

import com.solvd.library.books.Genre;
import com.solvd.library.others.Comics;
import com.solvd.library.others.SortByNameComics;

import java.util.ArrayList;

public class ComicsFactory {
    private final static ArrayList<Comics> COMICS = new ArrayList<>();

    public static void fillInComics() {
        COMICS.add(new Comics("Мстители", Genre.FANTASTIC));
        COMICS.add(new Comics("Манга", Genre.ADVENTURE));
        COMICS.add(new Comics("Очки", Genre.HORROR));
        COMICS.add(new Comics("Волшебник страны ОЗ", Genre.FANTASY));
    }

    public static Comics chooseComics(Genre genre) {
        COMICS.sort(new SortByNameComics());
        for (Comics com : COMICS) {
            if (com.getGenre() == genre) {
                COMICS.remove(com);
                return com;
            }
        }
        return null;
    }
}
