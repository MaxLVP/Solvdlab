package com.solvd.library.storage;

import com.solvd.library.cards.Card;
import com.solvd.library.visitors.Visitor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

import static com.solvd.library.storage.BooksFactory.chooseBook;

public class CardsFactory {
    private final static HashMap<String, Card> CARDS = new HashMap<>();

    public static void fillInCard(HashSet<Visitor> persons) {
        persons.forEach(person -> CARDS.put(person.getPhone(), new Card(person, chooseBook(person.getGenre()), null, null)));
    }

    public static void addCard(Card card) {
        CARDS.put(card.getVisitor().getPhone(), card);
    }

    public static Card returnCard(Visitor person) {
        Optional<String> visitorPhone = CARDS.keySet().stream().filter(phone -> phone.equals(person.getPhone())).findFirst();
        if (visitorPhone.isEmpty()) {
            return null;
        } else {
            return CARDS.get(visitorPhone.get());
        }
    }
}
