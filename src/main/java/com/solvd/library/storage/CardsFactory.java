package com.solvd.library.storage;

import com.solvd.library.books.Genre;
import com.solvd.library.cards.Card;
import com.solvd.library.visitors.Visitor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

import static com.solvd.library.storage.BooksFactory.chooseBook;

public class CardsFactory {
    private final static HashMap<String, Card> CARDS = new HashMap<>();

    public static void fillInCard(HashSet<Visitor> persons) {
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
