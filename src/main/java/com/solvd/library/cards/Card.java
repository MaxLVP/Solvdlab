package com.solvd.library.cards;

import com.solvd.library.books.Book;
import com.solvd.library.others.Comics;
import com.solvd.library.others.Periodicals;
import com.solvd.library.visitors.Visitor;

import java.util.Objects;

public final class Card {
    private final Visitor VISITOR;
    private Book books;
    private Periodicals periodicals;
    private Comics comics;

    public Card(Visitor person, Book books, Periodicals periodicals, Comics comics) {
        this.VISITOR = person;
        this.books = books;
        this.periodicals = periodicals;
        this.comics = comics;
    }

    public Comics getComics() {
        return comics;
    }

    public void setComics(Comics comics) {
        this.comics = comics;
    }

    public Visitor getVisitor() {
        return VISITOR;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    public Periodicals getPeriodicals() {
        return periodicals;
    }

    public void setPeriodicals(Periodicals periodicals) {
        this.periodicals = periodicals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return VISITOR.equals(card.VISITOR) && Objects.equals(books, card.books) && Objects.equals(periodicals, card.periodicals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(VISITOR, books, periodicals);
    }

    @Override
    public String toString() {
        String book;
        String comics;
        String periodicals;
        if (this.books == null) {
            book = "нет";
        } else {
            book = this.books.toString();
        }
        if (this.comics == null) {
            comics = "нет";
        } else {
            comics = this.comics.toString();
        }
        if (this.periodicals == null) {
            periodicals = "нет";
        } else {
            periodicals = this.periodicals.toString();
        }
        return "Карточка посетителя: " +
                "пользователь " + VISITOR.getName() +
                ", взятые книги: " + book +
                ", взятая периодика: " + periodicals +
                ", взятые комиксы: " + comics;
    }
}
