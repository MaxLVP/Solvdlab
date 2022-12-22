package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.PeriodicalNotFoundException;
import com.solvd.library.library.Giveaway;
import com.solvd.library.others.Periodicals;

public class MenuTakePeriodical {
    static final MyLogger LOGGER = MyLogger.getInstance();

    public static void takePeriodical(Card card) throws PeriodicalNotFoundException {
        Periodicals periodical = new Giveaway().giveaway(card);
        if (periodical == null) {
            LOGGER.info("Пользователю " + card.getVisitor().getName() + " ничего не выдано");
        } else {
            LOGGER.info("Пользователю " + card.getVisitor().getName() + " выдано: " + periodical);
            card.setPeriodicals(periodical);
            LOGGER.info(card);
        }
    }
}
