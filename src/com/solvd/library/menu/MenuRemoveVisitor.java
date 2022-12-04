package com.solvd.library.menu;

import com.solvd.library.cards.Card;
import com.solvd.library.visitors.Removal;
import com.solvd.library.visitors.Visitor;

public class MenuRemoveVisitor {

    public static void removeVisitor(Card card) {
        Visitor person = new Removal().remove(card.getVisitor());
        System.out.println("Пользователь с номером телефона " + person.getPhone() + " удален");
    }
}
