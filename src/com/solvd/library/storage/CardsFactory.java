package com.solvd.library.storage;

import com.solvd.library.books.Genre;
import com.solvd.library.cards.Card;
import com.solvd.library.visitors.Visitor;

import java.util.ArrayList;

import static com.solvd.library.storage.BooksFactory.chooseBook;
import org.apache.logging.log4j.Logger;

public class CardsFactory {
    private final ArrayList<Card> LIST = new ArrayList<>();

    public void fillInCard(ArrayList<Visitor> persons, Logger logger) {
        for (Visitor person : persons) {
            switch (person.getGenre()) {
                case "детектив" -> LIST.add(new Card(person, chooseBook(Genre.DETECTIVE, logger), null));
                case "ужасы" -> LIST.add(new Card(person, chooseBook(Genre.HORROR, logger), null));
                case "фэнтэзи" -> LIST.add(new Card(person, chooseBook(Genre.FANTASY, logger), null));
            }
        }
    }

    public Card returnCard(ArrayList<Visitor> persons, Visitor person, Logger logger) {
        fillInCard(persons, logger);
        for (Card card : LIST) {
            if (card.getVisitor().equals(person)) {
                return card;
            }
        }
        return null;
    }
}
