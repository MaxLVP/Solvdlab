package com.solvd.library.storage;

import com.solvd.library.books.Book;
import com.solvd.library.books.Detective;

import java.util.ArrayList;
import java.util.Random;

public class DetectiveBooks {
    private final ArrayList<Book> LIST = new ArrayList<>();

    public void fillIn() {
        LIST.add(new Detective("Смерть на Ниле", "Агата Кристи", 340));
        LIST.add(new Detective("Восточный экспресс", "Агата Кристи", 300));
        LIST.add(new Detective("Шерлок Холмс", "Артур Конан Дойл", 400));
        LIST.add(new Detective("Код да Винчи", "Дэн Браун", 500));
        LIST.add(new Detective("Десять нигретят", "Агата Кристи", 250));
    }

    public ArrayList<Book> getList() {
        return LIST;
    }

    public void addDetectiveBook(Book book) {
        LIST.add(book);
    }

    public Book chooseDetectiveBook() {
        fillIn();
        Random random = new Random();
        int i = random.nextInt(LIST.size() - 1);
        return LIST.get(i);
    }
}
