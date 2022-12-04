package com.solvd.library.menu;

import com.solvd.library.cards.Card;
import com.solvd.library.library.Giveaway;
import com.solvd.library.others.Periodicals;

public class MenuTakePeriodical {

    public static void takePeriodical(Card card) {
        Periodicals periodical = new Giveaway().giveaway();
        if (periodical == null) {
            System.out.println("Пользователю " + card.getVisitor().getName() + " ничего не выдано");
        } else {
            System.out.println("Пользователю " + card.getVisitor().getName() + " выдано: " + periodical);
            card.setPeriodicals(periodical);
            System.out.println(card);
        }
    }
}
