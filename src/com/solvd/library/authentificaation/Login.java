package com.solvd.library.authentificaation;

import com.solvd.library.cards.Card;
import com.solvd.library.cards.CardsData;
import com.solvd.library.visitors.Visitor;
import com.solvd.library.visitors.PersonData;

public class Login {

    public Card login(String phone) {
        PersonData data = new PersonData();
        data.fillInPerson();
        Visitor person = data.choosePerson(phone);
        return new CardsData().returnCard(data.getLIST(), person);
    }
}
