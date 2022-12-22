package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.cards.Card;

public class MenuExitLibrary {
    static final MyLogger LOGGER = MyLogger.getInstance();

    public static boolean exitLibrary(Card card) {
        if (card.getPeriodicals() != null) {
            LOGGER.info("У вас не сдана периодика " + card.getPeriodicals().getName());
            card.getPeriodicals().returnPeriodicals(card.getPeriodicals());
        }
        boolean exit = true;
        LOGGER.info("Всего хорошего");
        return exit;
    }
}
