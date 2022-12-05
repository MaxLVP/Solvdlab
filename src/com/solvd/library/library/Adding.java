package com.solvd.library.library;

import com.solvd.library.MyLogger;
import com.solvd.library.books.Book;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.GenreNotFoundException;
import com.solvd.library.exceptions.PersonBooksNotFound;

import java.util.Scanner;

import static com.solvd.library.storage.BooksFactory.addBook;

public class Adding {
    static final MyLogger logger = MyLogger.getInstance();

    public Book returnAndTakeBook(Card card) throws GenreNotFoundException {
        try {
            returnBook(card);
        } catch (PersonBooksNotFound ex) {
            logger.warn(ex.getMessage());
        }
        logger.info("Хотите ли вы взять книгу?");
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine();
        Book book = null;
        if ("да".equals(answer)) {
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
        book.readBook();
        logger.info(book + " сдана");
        card.setBooks(null);
    }
}
