package com.solvd.library.library;

import static com.solvd.library.storage.BooksFactory.fillInStorage;
import static com.solvd.library.storage.ComicsFactory.fillInComics;
import static com.solvd.library.storage.MagazinesFactory.fillInMagazines;
import static com.solvd.library.storage.NewsFactory.fillInNews;

public class FillInLibrary {

    public static void fillInLibrary() {
        fillInStorage();
        fillInMagazines();
        fillInComics();
        fillInNews();
    }
}
