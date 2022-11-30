package com.solvd.library.library;

import com.solvd.library.books.Book;
import com.solvd.library.books.Genre;
import com.solvd.library.cards.Card;

import java.util.Scanner;

import static com.solvd.library.storage.BooksFactory.chooseBook;

public class Suggestion {

    public Book suggest(Card card) {
        if (card.getBooks() == null) {
            String info = card.getVisitor().getGenre();
            switch (info) {
                case "детектив" -> {
                    Book book = chooseBook(Genre.DETECTIVE);
                    card.setBooks(book);
                    return book;
                }
                case "фэнтэзи" -> {
                    Book bookF = chooseBook(Genre.FANTASY);
                    card.setBooks(bookF);
                    return bookF;
                }
                case "ужасы" -> {
                    Book bookH = chooseBook(Genre.FANTASTIC);
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
        System.out.println("Хотите вернуть предуыщую? (да, нет)");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("да")) {
            return new Adding().returnAndTakeBook(card);
        }
        else {
            return null;
        }
    }
}
