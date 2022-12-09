package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.cards.Card;

public class MenuExitLibrary {
    static final MyLogger logger = MyLogger.getInstance();

    public static boolean exitLibrary(Card card) {
        if (card.getPeriodicals() != null) {
            logger.info("У вас не сдана периодика " + card.getPeriodicals().getName());
            card.getPeriodicals().returnPeriodicals(card.getPeriodicals());
        }
        boolean exit = true;
        logger.info("Всего хорошего");
        return exit;
    }
}
