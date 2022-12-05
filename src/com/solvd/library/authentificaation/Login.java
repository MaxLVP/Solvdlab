package com.solvd.library.authentificaation;

import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.PersonNotFoundException;
import com.solvd.library.storage.CardsFactory;
import com.solvd.library.visitors.Visitor;
import com.solvd.library.storage.VisitorFactory;
import org.apache.logging.log4j.Logger;

public class Login {

    public Card login(String phone, Logger logger) throws PersonNotFoundException {
        VisitorFactory data = new VisitorFactory();
        data.fillInVisitors();
        Visitor person = data.chooseVisitor(phone);
        Card card = new CardsFactory().returnCard(data.getLIST(), person, logger);
        if (card == null) {
            throw new PersonNotFoundException();
        }
        return card;
    }
}
