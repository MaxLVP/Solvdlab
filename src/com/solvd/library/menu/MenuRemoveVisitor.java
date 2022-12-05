package com.solvd.library.menu;

import com.solvd.library.cards.Card;
import com.solvd.library.visitors.Removal;
import com.solvd.library.visitors.Visitor;
import org.apache.logging.log4j.Logger;

public class MenuRemoveVisitor {

    public static void removeVisitor(Card card, Logger logger) {
        Visitor person = new Removal().remove(card.getVisitor());
        logger.info("Пользователь с номером телефона " + person.getPhone() + " удален");
    }
}
