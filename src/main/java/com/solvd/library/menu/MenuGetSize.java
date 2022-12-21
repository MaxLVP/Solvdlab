package com.solvd.library.menu;

import java.util.function.Supplier;

import static com.solvd.library.storage.BooksFactory.getBooksCount;
import static com.solvd.library.storage.BooksFactory.getBooksNames;
import static com.solvd.library.storage.ComicsFactory.getComicsCount;
import static com.solvd.library.storage.ComicsFactory.getComicsNames;
import static com.solvd.library.storage.MagazinesFactory.getMagazinesCount;
import static com.solvd.library.storage.MagazinesFactory.getMagazinesNames;
import static com.solvd.library.storage.NewsFactory.getNewsCount;
import static com.solvd.library.storage.NewsFactory.getNewsNames;

public class MenuGetSize {

    public static void getSizeOfLibrary() {
        Supplier<Boolean> supplier = () -> {
            getBooksCount();
            getBooksNames();
            getComicsCount();
            getComicsNames();
            getMagazinesCount();
            getMagazinesNames();
            getNewsCount();
            getNewsNames();
            return true;
        };
        supplier.get();
    }
}
