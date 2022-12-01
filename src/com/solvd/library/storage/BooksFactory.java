package com.solvd.library.storage;

import com.solvd.library.books.Book;
import com.solvd.library.books.Genre;

import java.util.ArrayList;
import java.util.Random;

public class BooksFactory {
    private final static ArrayList<Book> BOOK_LIST = new ArrayList<>();

    public static void fillInStorage() {
        BOOK_LIST.add(new Book("Смерть на Ниле", "Агата Кристи", 340, Genre.DETECTIVE));
        BOOK_LIST.add(new Book("Восточный экспресс", "Агата Кристи", 300, Genre.DETECTIVE));
        BOOK_LIST.add(new Book("Шерлок Холмс", "Артур Конан Дойл", 400, Genre.DETECTIVE));
        BOOK_LIST.add(new Book("Код да Винчи", "Дэн Браун", 500, Genre.DETECTIVE));
        BOOK_LIST.add(new Book("Десять нигретят", "Агата Кристи", 250, Genre.DETECTIVE));
        BOOK_LIST.add(new Book("Властелин колец", "Джон Толкин", 700, Genre.FANTASY));
        BOOK_LIST.add(new Book("Гарри Поттер", "Джоан Роулинг", 300, Genre.FANTASY));
        BOOK_LIST.add(new Book("Ведьмак", "Анджей Сапковски", 400, Genre.FANTASY));
        BOOK_LIST.add(new Book("Игра престолов", "Джордж Мартин", 500, Genre.FANTASY));
        BOOK_LIST.add(new Book("Волшебник Земноморья", "Урсула ле Гуин", 250, Genre.FANTASY));
        BOOK_LIST.add(new Book("Оно", "Стивен Кинг", 340, Genre.HORROR));
        BOOK_LIST.add(new Book("Мифы Ктулху", "Говард Лавкрафт", 300, Genre.HORROR));
        BOOK_LIST.add(new Book("Мертвая зона", "Стивен Кинг", 400, Genre.HORROR));
        BOOK_LIST.add(new Book("Красный дракон", "Томас Харрис", 500, Genre.HORROR));
        BOOK_LIST.add(new Book("Ритуал", "Адам Нэвилл", 250, Genre.HORROR));
    }

    public static ArrayList<Book> getBookList() {
        return BOOK_LIST;
    }

    public static void addBook(Book book) {
        BOOK_LIST.add(book);
    }

    public static Book chooseBook(Genre genre) {
        Random random = new Random();
        ArrayList<Book> genreBooks = new ArrayList<>();
        for (Book book : BOOK_LIST) {
            if (book.getGenre() == genre) {
                genreBooks.add(book);
            }
        }
        int i = random.nextInt(genreBooks.size());
        Book book = genreBooks.get(i);
        BOOK_LIST.remove(book);
        return book;
    }

}
