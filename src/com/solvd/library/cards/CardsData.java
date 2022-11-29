package com.solvd.library.cards;

import com.solvd.library.others.Comics;
import com.solvd.library.others.Papers;
import com.solvd.library.storage.DetectiveBooks;
import com.solvd.library.storage.FantasyBooks;
import com.solvd.library.storage.HorrorBooks;
import com.solvd.library.visitors.Person;

import java.util.ArrayList;

import static com.solvd.library.storage.DetectiveBooks.chooseDetectiveBook;
import static com.solvd.library.storage.FantasyBooks.chooseFantasyBook;
import static com.solvd.library.storage.HorrorBooks.chooseHorrorBook;

public class CardsData {
    private final ArrayList<Card> LIST = new ArrayList<>();

    public void fillInCard(ArrayList<Person> persons) {
        Comics papers = new Comics("name", "genre");
        for (Person person : persons) {
            switch (person.getGenre()) {
                case "детектив":
                    LIST.add(new Card(person, chooseDetectiveBook(), papers));
                case "ужасы":
                    LIST.add(new Card(person, chooseHorrorBook(), papers));
                case "фэнтэзи":
                    LIST.add(new Card(person, chooseFantasyBook(), papers));
            }
        }
    }

    public Card returnCard(ArrayList<Person> persons, Person person) {
        fillInCard(persons);
        for (Card card : LIST) {
            if (card.getPerson().equals(person)) {
                return card;
            }
        }
        return null;
    }
}
