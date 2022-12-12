package com.solvd.library.authentificaation;

import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.PersonNotFoundException;
import com.solvd.library.storage.CardsFactory;
import com.solvd.library.visitors.Visitor;
import com.solvd.library.storage.VisitorFactory;

public class Login {

    public Card login(String phone) throws PersonNotFoundException {
        VisitorFactory data = new VisitorFactory();
        data.fillInVisitors();
        Visitor person = data.chooseVisitor(phone);
        Card card = new CardsFactory().returnCard(data.getVisitors(), person);
        if (card == null) {
            throw new PersonNotFoundException();
        }
        return card;
    }
}
