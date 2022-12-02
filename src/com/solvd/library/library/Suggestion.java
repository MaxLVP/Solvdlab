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
                    Book book = chooseBook(Genre.FANTASY);
                    card.setBooks(book);
                    return book;
                }
                case "ужасы" -> {
                    Book book = chooseBook(Genre.HORROR);
                    card.setBooks(book);
                    return book;
                }
                case "приключения" -> {
                    Book book = chooseBook(Genre.ADVENTURE);
                    card.setBooks(book);
                    return book;
                }
                case "фантастика" -> {
                    Book book = chooseBook(Genre.FANTASTIC);
                    card.setBooks(book);
                    return book;
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
