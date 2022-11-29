package com.solvd.library.cards;

import com.solvd.library.books.Book;
import com.solvd.library.others.Papers;
import com.solvd.library.visitors.Person;

import java.util.Objects;

public class Card {
    private Person person;
    private Book books;
    private Papers papers;

    public Card(Person person, Book books, Papers papers) {
        this.person = person;
        this.books = books;
        this.papers = papers;
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

    public Papers getPapers() {
        return papers;
    }

    public void setPapers(Papers papers) {
        this.papers = papers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return person.equals(card.person) && Objects.equals(books, card.books) && Objects.equals(papers, card.papers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, books, papers);
    }

    @Override
    public String toString() {
        return "Карточка посетителя: " +
                "пользователь " + person.getName() +
                ", взятые книги: " + books +
                "взятая периодика: " + papers;
    }
}
