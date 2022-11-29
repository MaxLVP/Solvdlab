package com.solvd.library.library;

import com.solvd.library.books.Book;
import com.solvd.library.cards.Card;

import java.util.Scanner;

import static com.solvd.library.storage.DetectiveBooks.addDetectiveBook;
import static com.solvd.library.storage.FantasyBooks.addFantasyBook;
import static com.solvd.library.storage.HorrorBooks.addHorrorBook;

public class Adding {

    public Book returnAndTakeBook(Card card) {
        returnBook(card);
        System.out.println("Хотите ли вы взять книгу?");
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine();
        Book book = null;
        if ("да".equals(answer)) {
            book = new Suggestion().suggest(card);
        }
        return book;
    }

    public void returnBook(Card card) {
        String genre = card.getPerson().getGenre();
        switch (genre) {
            case "детектив" -> {
                Book book = card.getBooks();
                book.readBook();
                System.out.println(book + " сдана");
                addDetectiveBook(book);
                card.setBooks(null);
            }
            case "ужасы" -> {
                Book book = card.getBooks();
                book.readBook();
                System.out.println(book + " сдана");
                addHorrorBook(book);
                card.setBooks(null);
            }
            case "фэнтэзи" -> {
                Book book = card.getBooks();
                book.readBook();
                System.out.println(book + " сдана");
                addFantasyBook(book);
                card.setBooks(null);
            }
        }
    }
}
