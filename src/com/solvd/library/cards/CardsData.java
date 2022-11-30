package com.solvd.library.cards;

import com.solvd.library.books.Genre;
import com.solvd.library.others.Comics;
import com.solvd.library.visitors.Visitor;

import java.util.ArrayList;

import static com.solvd.library.storage.BooksFactory.chooseBook;

public class CardsData {
    private final ArrayList<Card> LIST = new ArrayList<>();

    public void fillInCard(ArrayList<Visitor> persons) {
        Comics papers = new Comics("name", "genre");
        for (Visitor person : persons) {
            switch (person.getGenre()) {
                case "детектив":
                    LIST.add(new Card(person, chooseBook(Genre.DETECTIVE), papers));
                case "ужасы":
                    LIST.add(new Card(person, chooseBook(Genre.HORROR), papers));
                case "фэнтэзи":
                    LIST.add(new Card(person, chooseBook(Genre.FANTASY), papers));
            }
        }
    }

    public Card returnCard(ArrayList<Visitor> persons, Visitor person) {
        fillInCard(persons);
        for (Card card : LIST) {
            if (card.getVisitor().equals(person)) {
                return card;
            }
        }
        return null;
    }
}
