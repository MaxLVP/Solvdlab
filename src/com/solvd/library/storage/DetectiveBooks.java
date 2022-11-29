package com.solvd.library.storage;

import com.solvd.library.books.Book;
import com.solvd.library.books.Detective;

import java.util.ArrayList;
import java.util.Random;

public class DetectiveBooks {
    private final static ArrayList<Book> LIST = new ArrayList<>();

    public static void fillIn() {
        LIST.add(new Detective("Смерть на Ниле", "Агата Кристи", 340));
        LIST.add(new Detective("Восточный экспресс", "Агата Кристи", 300));
        LIST.add(new Detective("Шерлок Холмс", "Артур Конан Дойл", 400));
        LIST.add(new Detective("Код да Винчи", "Дэн Браун", 500));
        LIST.add(new Detective("Десять нигретят", "Агата Кристи", 250));
    }

    public ArrayList<Book> getList() {
        return LIST;
    }

    public static void addDetectiveBook(Book book) {
        LIST.add(book);
    }

    public static Book chooseDetectiveBook() {
        fillIn();
        Random random = new Random();
        int i = random.nextInt(LIST.size() - 1);
        Book book = LIST.get(i);
        LIST.remove(i);
        return book;
    }
}
