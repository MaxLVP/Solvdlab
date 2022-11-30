package com.solvd.library.cards;

import com.solvd.library.books.Book;
import com.solvd.library.others.Periodicals;
import com.solvd.library.visitors.Visitor;

import java.util.Objects;

public class Card {
    private Visitor visitor;
    private Book books;
    private Periodicals periodicals;

    public Card(Visitor person, Book books, Periodicals periodicals) {
        this.visitor = person;
        this.books = books;
        this.periodicals = periodicals;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    public Periodicals getPapers() {
        return periodicals;
    }

    public void setPapers(Periodicals periodicals) {
        this.periodicals = periodicals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return visitor.equals(card.visitor) && Objects.equals(books, card.books) && Objects.equals(periodicals, card.periodicals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitor, books, periodicals);
    }

    @Override
    public String toString() {
        if (this.books == null) {
            return "Карточка посетителя: " +
                    "пользователь " + visitor.getName() +
                    ", взятых книг нет " +
                    "взятая периодика: " + periodicals;
        }
        return "Карточка посетителя: " +
                "пользователь " + visitor.getName() +
                ", взятые книги: " + books +
                "взятая периодика: " + periodicals;
    }
}
