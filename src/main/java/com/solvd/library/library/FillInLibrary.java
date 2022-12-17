package com.solvd.library.library;

import com.solvd.library.utils.StartStaticFunction;

import static com.solvd.library.storage.BooksFactory.fillInStorage;
import static com.solvd.library.storage.CardsFactory.fillInCard;
import static com.solvd.library.storage.ComicsFactory.fillInComics;
import static com.solvd.library.storage.MagazinesFactory.fillInMagazines;
import static com.solvd.library.storage.NewsFactory.fillInNews;
import static com.solvd.library.storage.VisitorFactory.fillInVisitors;
import static com.solvd.library.storage.VisitorFactory.getVisitors;

public class FillInLibrary {

    public static void fillInLibrary() {
        StartStaticFunction start = () -> {
            fillInStorage();
            fillInMagazines();
            fillInComics();
            fillInNews();
            fillInVisitors();
            fillInCard(getVisitors());
        };
        start.run();
    }
}
