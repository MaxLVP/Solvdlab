package com.solvd.library.authentificaation;

import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.PersonNotFoundException;
import com.solvd.library.visitors.Visitor;

import static com.solvd.library.storage.CardsFactory.returnCard;
import static com.solvd.library.storage.VisitorFactory.chooseVisitor;

public class Login {

    public Card login(String phone) throws PersonNotFoundException {
        Visitor person = chooseVisitor(phone);
        if (person == null) {
            throw new PersonNotFoundException();
        }
        Card card = returnCard(person);
        if (card == null) {
            throw new PersonNotFoundException();
        }
        return card;
    }
}
