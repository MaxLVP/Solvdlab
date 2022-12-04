package com.solvd.library.menu;

import com.solvd.library.books.Book;
import com.solvd.library.cards.Card;
import com.solvd.library.library.Suggestion;

public class MenuTakeBook {

    public static void takeBook(Card card) {
        Book book = new Suggestion().suggest(card);
        if (book == null) {
            System.out.println("Пользователю " + card.getVisitor().getName() + " ничего не выдано");
        } else {
            System.out.println("Взята " + book);
        }
        System.out.println(card);
    }
}
