package com.solvd.library.library;

import com.solvd.library.MyLogger;
import com.solvd.library.books.Book;
import com.solvd.library.cards.Card;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

import static com.solvd.library.storage.BooksFactory.chooseBook;

public class Suggestion {
    static final MyLogger LOGGER = MyLogger.getInstance();

    public Book suggest(Card card) {
        if (card.getBooks() == null) {
            Book book = getRandomBook(card);
            card.setBooks(book);
            return book;
        }
        LOGGER.info("У вас уже взята книга, верните предыдующую");
        LOGGER.info("Хотите вернуть предуыщую? (да, нет)");
        Scanner scanner = new Scanner(System.in);
        if (StringUtils.lowerCase(scanner.nextLine()).contains("д")) {
            return new Returning().returnAndTakeBook(card);
        } else {
            return null;
        }
    }

    public static Book getRandomBook(Card card) {
        Book book = chooseBook(card.getVisitor().getGenre());
        LOGGER.info("Вы уже читали книгу? " + book);
        Scanner scanner = new Scanner(System.in);
        while (StringUtils.lowerCase(scanner.nextLine()).contains("д")) {
            book = getRandomBook(card);
        }
        return book;
    }
}
