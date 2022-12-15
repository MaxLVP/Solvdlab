package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.authentificaation.Auth;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.GenreNotFoundException;
import com.solvd.library.exceptions.PeriodicalNotFoundException;

import static com.solvd.library.menu.Menu.menu;
import static com.solvd.library.storage.CardsFactory.addCard;

public class MenuChangeVisitor {
    static final MyLogger logger = MyLogger.getInstance();

    public static void changeVisitor(Card card, Auth authentication) throws PeriodicalNotFoundException, GenreNotFoundException {
        if (card.getPeriodicals() != null) {
            logger.info("У вас не сдана периодика " + card.getPeriodicals().getName());
            card.getPeriodicals().returnPeriodicals(card.getPeriodicals());
        }
        addCard(card);
        logger.info("Выход из системы");
        card = authentication.auth();
        logger.info("В систему вошел пользователь: " + card.getVisitor());
        logger.info(card);
        menu(card, authentication, false);
    }
}
