package com.solvd.library.library;

import com.solvd.library.books.Book;
import com.solvd.library.cards.Card;

import static com.solvd.library.storage.DetectiveBooks.chooseDetectiveBook;
import static com.solvd.library.storage.FantasyBooks.chooseFantasyBook;
import static com.solvd.library.storage.HorrorBooks.chooseHorrorBook;

public class Suggestion {

    public Book suggest(Card card) {
        if (card.getBooks() == null) {
            String info = card.getPerson().getGenre();
            switch (info) {
                case "детектив" -> {
                    Book book = chooseDetectiveBook();
                    card.setBooks(book);
                    return book;
                }
                case "фэнтэзи" -> {
                    Book bookF = chooseFantasyBook();
                    card.setBooks(bookF);
                    return bookF;
                }
                case "ужасы" -> {
                    Book bookH = chooseHorrorBook();
                    card.setBooks(bookH);
                    return bookH;
                }
                default -> {
                    System.out.println("Введено неправильно наименование");
                    return null;
                }
            }
        }
        System.out.println("У вас уже взята книга, верните предыдующую");
        return null;
    }
}
