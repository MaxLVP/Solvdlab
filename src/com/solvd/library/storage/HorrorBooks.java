package com.solvd.library.storage;

import com.solvd.library.books.Book;
import com.solvd.library.books.Horror;

import java.util.ArrayList;
import java.util.Random;

public class HorrorBooks {
    private final static ArrayList<Book> LIST = new ArrayList<>();

    public static void fillIn() {
        LIST.add(new Horror("Оно", "Стивен Кинг", 340));
        LIST.add(new Horror("Мифы Ктулху", "Говард Лавкрафт", 300));
        LIST.add(new Horror("Мертвая зона", "Стивен Кинг", 400));
        LIST.add(new Horror("Красный дракон", "Томас Харрис", 500));
        LIST.add(new Horror("Ритуал", "Адам Нэвилл", 250));
    }

    public ArrayList<Book> getList() {
        return LIST;
    }

    public static void addHorrorBook(Book book) {
        LIST.add(book);
    }

    public static Book chooseHorrorBook() {
        fillIn();
        Random random = new Random();
        int i = random.nextInt(LIST.size() - 1);
        return LIST.get(i);
    }
}
