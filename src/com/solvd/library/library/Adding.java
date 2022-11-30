package com.solvd.library.library;

import com.solvd.library.books.Book;
import com.solvd.library.cards.Card;

import java.util.Scanner;

import static com.solvd.library.storage.BooksFactory.addBook;

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
        Book book = card.getBooks();
        addBook(book);
        book.readBook();
        System.out.println(book + " сдана");
        card.setBooks(null);
    }
}
