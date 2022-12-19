package com.solvd.library.storage;

import com.solvd.library.MyLogger;
import com.solvd.library.books.Genre;
import com.solvd.library.others.Comics;
import com.solvd.library.others.SortByNameComics;
import com.solvd.library.utils.IConvert;

import java.util.ArrayList;

public class ComicsFactory {
    static final MyLogger logger = MyLogger.getInstance();
    private final static ArrayList<Comics> COMICS = new ArrayList<>();

    public static void fillInComics() {
        COMICS.add(new Comics("Мстители", Genre.FANTASTIC));
        COMICS.add(new Comics("Манга", Genre.ADVENTURE));
        COMICS.add(new Comics("Очки", Genre.HORROR));
        COMICS.add(new Comics("Волшебник страны ОЗ", Genre.FANTASY));
    }

    public static void addComics(Comics comic) {
        COMICS.add(comic);
        logger.info(COMICS);
    }

    public static Comics chooseComics(Genre genre) {
        COMICS.sort(new SortByNameComics());
        logger.info(COMICS);
        for (Comics com : COMICS) {
            if (com.getGenre() == genre) {
                COMICS.remove(com);
                logger.info(COMICS);
                return com;
            }
        }
        return null;
    }

    public static void getComicsCount() {
        IConvert<Integer, String> convert = size -> size.toString();
        logger.info("Количество комиксов: " + convert.convert(COMICS.size()));
    }
}
