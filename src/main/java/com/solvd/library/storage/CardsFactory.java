package com.solvd.library.storage;

import com.solvd.library.books.Genre;
import com.solvd.library.cards.Card;
import com.solvd.library.visitors.Visitor;

import java.util.HashMap;
import java.util.HashSet;

import static com.solvd.library.storage.BooksFactory.chooseBook;

public class CardsFactory {
    private final HashMap<String, Card> CARDS = new HashMap<>();

    public void fillInCard(HashSet<Visitor> persons) {
        for (Visitor person : persons) {
            switch (person.getGenre()) {
                case "детектив" -> CARDS.put(person.getPhone(), new Card(person, chooseBook(Genre.DETECTIVE), null, null));
                case "ужасы" -> CARDS.put(person.getPhone(), new Card(person, chooseBook(Genre.HORROR), null, null));
                case "фэнтэзи" -> CARDS.put(person.getPhone(), new Card(person, chooseBook(Genre.FANTASY), null, null));
                case "приключения" -> CARDS.put(person.getPhone(), new Card(person, chooseBook(Genre.ADVENTURE), null, null));
                case "фантастика" -> CARDS.put(person.getPhone(), new Card(person, chooseBook(Genre.FANTASTIC), null, null));
            }
        }
    }

    public Card returnCard(HashSet<Visitor> persons, Visitor person) {
        fillInCard(persons);
        for (String phone : CARDS.keySet()) {
            if (phone.equals(person.getPhone())) {
                return CARDS.get(phone);
            }
        }
        return null;
    }
}
