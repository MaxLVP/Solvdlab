package com.solvd.library.library;

import com.solvd.library.books.Book;
import com.solvd.library.cards.Card;
import com.solvd.library.storage.DetectiveBooks;
import com.solvd.library.storage.FantasyBooks;
import com.solvd.library.storage.HorrorBooks;

public class Suggestion {

    public Book suggest(Card card, DetectiveBooks decBook, FantasyBooks fanBook, HorrorBooks horBook) {
        if (card.getBooks() == null) {
            String info = card.getPerson().getGenre();
            switch (info) {
                case "детектив" -> {
                    Book book = decBook.chooseDetectiveBook();
                    card.setBooks(book);
                    return book;
                }
                case "фэнтэзи" -> {
                    Book bookF = fanBook.chooseFantasyBook();
                    card.setBooks(bookF);
                    return bookF;
                }
                case "ужасы" -> {
                    Book bookH = horBook.chooseHorrorBook();
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
