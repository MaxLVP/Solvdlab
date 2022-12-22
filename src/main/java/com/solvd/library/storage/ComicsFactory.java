package com.solvd.library.storage;

import com.solvd.library.MyLogger;
import com.solvd.library.books.Genre;
import com.solvd.library.exceptions.LibraryBooksNotFound;
import com.solvd.library.others.Comics;
import com.solvd.library.utils.custom_lambda.IConvert;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.solvd.library.utils.RandomUtils.returnRandomIntWithSize;

public class ComicsFactory {
    static final MyLogger LOGGER = MyLogger.getInstance();
    private final static ArrayList<Comics> COMICS = new ArrayList<>();

    public static void fillInComics() {
        COMICS.add(new Comics("Мстители", Genre.FANTASTIC));
        COMICS.add(new Comics("Манга", Genre.ADVENTURE));
        COMICS.add(new Comics("Очки", Genre.HORROR));
        COMICS.add(new Comics("Волшебник страны ОЗ", Genre.FANTASY));
    }

    public static void addComics(Comics comic) {
        COMICS.add(comic);
    }

    public static Comics chooseComics(Genre genre) {
        COMICS.sort(Comics::compareTo);
        List<Comics> comics = COMICS.stream().filter(com -> com.getGenre() == genre).toList();
        try {
            Comics comic = chooseComicsForGenre(comics);
            COMICS.remove(comic);
            return comic;
        } catch (LibraryBooksNotFound ex) {
            LOGGER.warn(ex.getMessage());
            return null;
        }
    }

    public static Comics chooseComicsForGenre(List<Comics> comics) throws LibraryBooksNotFound {
        if (comics.size() == 0) {
            throw new LibraryBooksNotFound();
        }
        return comics.get(returnRandomIntWithSize(comics.size()));
    }

    public static void getComicsNames() {
        List<String> comicsNames = COMICS.stream().map(comics -> StringUtils.capitalize(comics.getName())).toList();
        LOGGER.info("Комиксы : " + comicsNames);
    }

    public static void getComicsCount() {
        IConvert<Integer, String> convert = Object::toString;
        LOGGER.info("Общее количество комиксов: " + convert.convert(COMICS.size()));
    }
}
