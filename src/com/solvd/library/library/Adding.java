package com.solvd.library.library;

import com.solvd.library.books.Book;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.GenreNotFoundException;
import com.solvd.library.exceptions.PersonBooksNotFound;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import static com.solvd.library.storage.BooksFactory.addBook;

public class Adding {

    public Book returnAndTakeBook(Card card, Logger logger) throws GenreNotFoundException {
        try {
            returnBook(card, logger);
        } catch (PersonBooksNotFound ex) {
            logger.warn(ex.getMessage());
        }
        logger.info("Хотите ли вы взять книгу?");
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine();
        Book book = null;
        if ("да".equals(answer)) {
            book = new Suggestion().suggest(card, logger);
        }
        return book;
    }

    public void returnBook(Card card, Logger logger) throws PersonBooksNotFound {
        Book book = card.getBooks();
        if (book == null) {
            throw new PersonBooksNotFound();
        }
        addBook(book);
        book.readBook();
        logger.info(book + " сдана");
        card.setBooks(null);
    }
}
