package com.solvd.library.cards;

import com.solvd.library.books.Book;
import com.solvd.library.visitors.Person;

import java.util.Objects;

public class Card {
    private Person person;
    private Book books;

    public Card(Person person, Book books) {
        this.person = person;
        this.books = books;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return person.equals(card.person) && Objects.equals(books, card.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, books);
    }

    @Override
    public String toString() {
        return "Карточка посетителя: " +
                "пользователь " + person.getName() +
                ", взятые книги: " + books;
    }
}
