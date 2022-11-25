package com.solvd.library.authentificaation;

import com.solvd.library.cards.Card;
import com.solvd.library.cards.CardsData;
import com.solvd.library.storage.DetectiveBooks;
import com.solvd.library.storage.FantasyBooks;
import com.solvd.library.storage.HorrorBooks;
import com.solvd.library.visitors.Person;
import com.solvd.library.visitors.PersonData;

public class Login {

    public Card login(String phone, DetectiveBooks decBook, FantasyBooks fanBook, HorrorBooks horBook) {
        PersonData data = new PersonData();
        data.fillInPerson();
        Person person = data.choosePerson(phone);
        return new CardsData().returnCard(data.getLIST(), person, decBook, fanBook, horBook);
    }
}
