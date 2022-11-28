package com.solvd.library.library;

import com.solvd.library.books.Book;
import com.solvd.library.cards.Card;
import com.solvd.library.storage.DetectiveBooks;
import com.solvd.library.storage.FantasyBooks;
import com.solvd.library.storage.HorrorBooks;

import java.util.Scanner;

public class Adding {

    public Book returnAndTakeBook(Card card, DetectiveBooks decBook, FantasyBooks fanBook, HorrorBooks horBook) {
        returnBook(card, decBook, fanBook, horBook);
        System.out.println("Хотите ли вы взять книгу?");
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine();
        Book book = null;
        if ("да".equals(answer)) {
            book = new Suggestion().suggest(card, decBook, fanBook, horBook);
        }
        return book;
    }

    public void returnBook(Card card, DetectiveBooks decBook, FantasyBooks fanBook, HorrorBooks horBook) {
        String genre = card.getPerson().getGenre();
        switch (genre) {
            case "детектив" -> {
                Book book = card.getBooks();
                book.readBook();
                System.out.println(book + " сдана");
                decBook.addDetectiveBook(book);
                card.setBooks(null);
            }
            case "ужасы" -> {
                Book book = card.getBooks();
                book.readBook();
                System.out.println(book + " сдана");
                horBook.addHorrorBook(book);
                card.setBooks(null);
            }
            case "фэнтэзи" -> {
                Book book = card.getBooks();
                book.readBook();
                System.out.println(book + " сдана");
                fanBook.addFantasyBook(book);
                card.setBooks(null);
            }
        }
    }
}
