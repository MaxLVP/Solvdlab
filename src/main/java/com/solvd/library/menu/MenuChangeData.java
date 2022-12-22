package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.cards.Card;
import com.solvd.library.visitors.ChangeVisitorData;
import com.solvd.library.visitors.Visitor;

import java.util.function.Consumer;

public class MenuChangeData {
    static final MyLogger LOGGER = MyLogger.getInstance();

    public static void changeVisitorDataMenu(Card card) {
        Consumer<Visitor> consumer = ChangeVisitorData::changeVisitorData;
        consumer.accept(card.getVisitor());
        LOGGER.info("Данные изменены");
        LOGGER.info(card.getVisitor());
    }
}
