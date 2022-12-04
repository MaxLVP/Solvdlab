package com.solvd.library.menu;

import com.solvd.library.books.Book;
import com.solvd.library.cards.Card;
import com.solvd.library.library.Adding;

public class MenuReturnBook {

    public static void returnBook(Card card) {
        Book books = new Adding().returnAndTakeBook(card);
        if (books == null) {
            System.out.println("Пользователю " + card.getVisitor().getName() + " ничего не выдано");
        } else {
            System.out.println("Взята " + books);
        }
        System.out.println(card);
    }
}
