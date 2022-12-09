package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.cards.Card;

import static com.solvd.library.visitors.ChangeVisitorData.changeVisitorData;

public class MenuChangeData {
    static final MyLogger logger = MyLogger.getInstance();

    public static void changeVisitorDataMenu(Card card) {
        changeVisitorData(card.getVisitor());
        logger.info("Данные изменены");
        logger.info(card.getVisitor());
    }
}
