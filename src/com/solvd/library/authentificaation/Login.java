package com.solvd.library.authentificaation;

import com.solvd.library.cards.Card;
import com.solvd.library.storage.CardsFactory;
import com.solvd.library.visitors.Visitor;
import com.solvd.library.storage.VisitorFactory;

public class Login {

    public Card login(String phone) {
        VisitorFactory data = new VisitorFactory();
        data.fillInVisitors();
        Visitor person = data.chooseVisitor(phone);
        return new CardsFactory().returnCard(data.getLIST(), person);
    }
}
