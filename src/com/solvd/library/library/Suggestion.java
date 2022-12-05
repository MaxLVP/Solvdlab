package com.solvd.library.library;

import com.solvd.library.books.Book;
import com.solvd.library.books.Genre;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.GenreNotFoundException;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import static com.solvd.library.storage.BooksFactory.chooseBook;

public class Suggestion {

    public Book suggest(Card card, Logger logger) throws GenreNotFoundException {
        if (card.getBooks() == null) {
            String info = card.getVisitor().getGenre();
            switch (info) {
                case "детектив" -> {
                    Book book = chooseBook(Genre.DETECTIVE, logger);
                    card.setBooks(book);
                    return book;
                }
                case "фэнтэзи" -> {
                    Book book = chooseBook(Genre.FANTASY, logger);
                    card.setBooks(book);
                    return book;
                }
                case "ужасы" -> {
                    Book book = chooseBook(Genre.HORROR, logger);
                    card.setBooks(book);
                    return book;
                }
                case "приключения" -> {
                    Book book = chooseBook(Genre.ADVENTURE, logger);
                    card.setBooks(book);
                    return book;
                }
                case "фантастика" -> {
                    Book book = chooseBook(Genre.FANTASTIC, logger);
                    card.setBooks(book);
                    return book;
                }
                default -> throw new GenreNotFoundException();
            }
        }
        logger.info("У вас уже взята книга, верните предыдующую");
        logger.info("Хотите вернуть предуыщую? (да, нет)");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("да")) {
            return new Adding().returnAndTakeBook(card, logger);
        }
        else {
            return null;
        }
    }
}
