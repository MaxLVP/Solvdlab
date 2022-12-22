package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.cards.Card;
import com.solvd.library.visitors.Removal;
import com.solvd.library.visitors.Visitor;

public class MenuRemoveVisitor {
    static final MyLogger LOGGER = MyLogger.getInstance();

    public static void removeVisitor(Card card) {
        Visitor person = new Removal().remove(card.getVisitor());
        LOGGER.info("Пользователь с номером телефона " + person.getPhone() + " удален");
    }
}
