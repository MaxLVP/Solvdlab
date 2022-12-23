package com.solvd.library.menu;

import com.solvd.library.cards.Card;

import java.util.function.Supplier;

import static com.solvd.library.storage.BooksFactory.*;
import static com.solvd.library.storage.ComicsFactory.printComicsCount;
import static com.solvd.library.storage.ComicsFactory.printComicsNames;
import static com.solvd.library.storage.MagazinesFactory.printMagazinesCount;
import static com.solvd.library.storage.MagazinesFactory.printMagazinesNames;
import static com.solvd.library.storage.NewsFactory.printNewsCount;
import static com.solvd.library.storage.NewsFactory.printNewsNames;

public class MenuGetSize {

    public static void getSizeOfLibrary() {
        Supplier<Boolean> supplier = () -> {
            printBooksCount();
            printAllBooks();
            printComicsCount();
            printComicsNames();
            printMagazinesCount();
            printMagazinesNames();
            printNewsCount();
            printNewsNames();
            return true;
        };
        supplier.get();
    }

    public static void getBooksFromGenre(Card card) {
        printBooksNames(card.getVisitor());
    }
}
