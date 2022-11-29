package com.solvd.library;

import com.solvd.library.authentificaation.Auth;
import com.solvd.library.books.Book;
import com.solvd.library.books.Genre;
import com.solvd.library.cards.Card;
import com.solvd.library.library.Adding;
import com.solvd.library.library.Giveaway;
import com.solvd.library.library.Suggestion;
import com.solvd.library.others.Papers;
import com.solvd.library.storage.DetectiveBooks;
import com.solvd.library.storage.FantasyBooks;
import com.solvd.library.storage.HorrorBooks;
import com.solvd.library.visitors.Person;
import com.solvd.library.visitors.Removal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Removal remove = new Removal();
        System.out.println("Добро пожаловать");
        Card card = new Auth().auth();
        System.out.println("В систему вошел пользователь: " + card.getPerson());
        System.out.println(card);
        System.out.println("Что вы хотите сделать?");
        System.out.println("1. Взять книгу ");
        System.out.println("2. Сдать книгу ");
        System.out.println("3. Взять журнал, газету или комиксы ");
        System.out.println("4. Удалить себя из базы данных ");
        System.out.println("5. Уйти из библиотеки");
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        switch (i) {
            case 1:
                Book book = new Suggestion().suggest(card);
                if (book == null) {
                    System.out.println("Пользователю " + card.getPerson().getName() + " ничего не выдано");
                }
                else {
                    System.out.println("Взята " + book);
                }
                System.out.println(card);
                break;
            case 2:
                Book books = new Adding().returnAndTakeBook(card);
                if (books == null) {
                    System.out.println("Пользователю " + card.getPerson().getName() + " ничего не выдано");
                }
                else {
                    System.out.println("Взята " + books);
                }
                System.out.println(card);
                break;
            case 3:
                Papers paper = new Giveaway().giveaway();
                if (paper == null) {
                    System.out.println("Пользователю " + card.getPerson().getName() + " ничего не выдано");
                }
                else {
                    System.out.println("Пользователю " + card.getPerson().getName() + " выдано: " + paper);
                }
                break;
            case 4:
                Person person = remove.remove(card.getPerson());
                break;
            case 5:
                if (card.getPapers() == null) {
                    System.out.println("Всего хорошего");
                }
                else {
                    System.out.println("У вас не сдана периодика " + card.getPapers().getName());
                    card.getPapers().returnPeriodicals();
                    System.out.println("Всего хорошего");
                }
        }
        System.out.println("");
        System.out.println("Выход из программы");
    }
}