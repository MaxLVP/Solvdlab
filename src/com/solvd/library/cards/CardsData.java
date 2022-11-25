package com.solvd.library.cards;

import com.solvd.library.storage.DetectiveBooks;
import com.solvd.library.storage.FantasyBooks;
import com.solvd.library.storage.HorrorBooks;
import com.solvd.library.visitors.Person;

import java.util.ArrayList;

public class CardsData {
    private final ArrayList<Card> LIST = new ArrayList<>();

    public void fillInCard(ArrayList<Person> persons, DetectiveBooks decBook, FantasyBooks fanBook, HorrorBooks horBook) {
        for (Person person : persons) {
            switch (person.getGenre()) {
                case "детектив":
                    LIST.add(new Card(person, decBook.chooseDetectiveBook()));
                case "ужасы":
                    LIST.add(new Card(person, horBook.chooseHorrorBook()));
                case "фэнтэзи":
                    LIST.add(new Card(person, fanBook.chooseFantasyBook()));
            }
        }
    }

    public Card returnCard(ArrayList<Person> persons, Person person, DetectiveBooks decBook, FantasyBooks fanBook, HorrorBooks horBook) {
        fillInCard(persons, decBook, fanBook, horBook);
        for (Card card : LIST) {
            if (card.getPerson().equals(person)) {
                return card;
            }
        }
        return null;
    }
}
