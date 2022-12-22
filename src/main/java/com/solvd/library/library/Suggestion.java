package com.solvd.library.library;

import com.solvd.library.MyLogger;
import com.solvd.library.books.Book;
import com.solvd.library.books.Genre;
import com.solvd.library.cards.Card;

import java.util.Scanner;

import static com.solvd.library.storage.BooksFactory.chooseBook;
import static com.solvd.library.utils.ReturnVisitorGenreUtil.returnGenre;

public class Suggestion {
    static final MyLogger LOGGER = MyLogger.getInstance();

    public Book suggest(Card card) {
        if (card.getBooks() == null) {
            Genre genre = returnGenre(card.getVisitor());
            Book book = chooseBook(genre);
            card.setBooks(book);
            return book;
        }
        LOGGER.info("У вас уже взята книга, верните предыдующую");
        LOGGER.info("Хотите вернуть предуыщую? (да, нет)");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("да")) {
            return new Returning().returnAndTakeBook(card);
        }
        else {
            return null;
        }
    }
}
