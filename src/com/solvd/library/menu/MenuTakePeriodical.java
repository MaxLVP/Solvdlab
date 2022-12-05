package com.solvd.library.menu;

import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.PeriodicalNotFoundException;
import com.solvd.library.library.Giveaway;
import com.solvd.library.others.Periodicals;
import org.apache.logging.log4j.Logger;

public class MenuTakePeriodical {

    public static void takePeriodical(Card card, Logger logger) throws PeriodicalNotFoundException {
        Periodicals periodical = new Giveaway().giveaway(logger);
        if (periodical == null) {
            logger.info("Пользователю " + card.getVisitor().getName() + " ничего не выдано");
        } else {
            logger.info("Пользователю " + card.getVisitor().getName() + " выдано: " + periodical);
            card.setPeriodicals(periodical);
            logger.info(card);
        }
    }
}
