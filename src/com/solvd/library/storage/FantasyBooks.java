package com.solvd.library.storage;

import com.solvd.library.books.Book;
import com.solvd.library.books.Fantasy;

import java.util.ArrayList;
import java.util.Random;

public class FantasyBooks {
    private final static ArrayList<Book> LIST = new ArrayList<>();

    public static void fillIn() {
        LIST.add(new Fantasy("Властелин колец", "Джон Толкин", 700));
        LIST.add(new Fantasy("Гарри Поттер", "Джоан Роулинг", 300));
        LIST.add(new Fantasy("Ведьмак", "Анджей Сапковски", 400));
        LIST.add(new Fantasy("Игра престолов", "Джордж Мартин", 500));
        LIST.add(new Fantasy("Волшебник Земноморья", "Урсула ле Гуин", 250));
    }

    public ArrayList<Book> getList() {
        return LIST;
    }

    public static void addFantasyBook(Book book) {
        LIST.add(book);
    }

    public static Book chooseFantasyBook() {
        fillIn();
        Random random = new Random();
        int i = random.nextInt(LIST.size() - 1);
        return LIST.get(i);
    }
}
