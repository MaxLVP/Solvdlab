package com.solvd.library.library;

import com.solvd.library.MyLogger;
import com.solvd.library.books.Book;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.PersonBooksNotFound;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

import static com.solvd.library.storage.BooksFactory.addBook;

public class Returning {
    static final MyLogger LOGGER = MyLogger.getInstance();

    public Book returnAndTakeBook(Card card) {
        try {
            returnBook(card);
        } catch (PersonBooksNotFound ex) {
            LOGGER.warn(ex.getMessage());
        }
        LOGGER.info("Хотите ли вы взять книгу?");
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine();
        Book book = null;
        if (StringUtils.lowerCase(answer).contains("д")) {
            book = new Suggestion().suggest(card);
        }
        return book;
    }

    public void returnBook(Card card) throws PersonBooksNotFound {
        Book book = card.getBooks();
        if (book == null) {
            throw new PersonBooksNotFound();
        }
        addBook(book);
        book.returnBook();
        LOGGER.info(book + " сдана");
        card.setBooks(null);
    }
}
