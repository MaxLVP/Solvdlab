package com.solvd.library.menu;

import java.util.function.Supplier;

import static com.solvd.library.storage.BooksFactory.getBooksCount;
import static com.solvd.library.storage.ComicsFactory.getComicsCount;
import static com.solvd.library.storage.MagazinesFactory.getMagazinesCount;
import static com.solvd.library.storage.NewsFactory.getNewsCount;

public class MenuGetSize {

    public static void getSizeOfLibrary() {
        Supplier<Boolean> supplier = () -> {
            getBooksCount();
            getComicsCount();
            getMagazinesCount();
            getNewsCount();
            return true;
        };
        supplier.get();
    }
}
