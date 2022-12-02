package com.solvd.library;

import com.solvd.library.authentificaation.Auth;
import com.solvd.library.books.Book;
import com.solvd.library.cards.Card;
import com.solvd.library.library.Adding;
import com.solvd.library.library.Giveaway;
import com.solvd.library.library.Suggestion;
import com.solvd.library.others.Periodicals;
import com.solvd.library.visitors.Visitor;
import com.solvd.library.visitors.Removal;

import java.util.Scanner;

import static com.solvd.library.storage.BooksFactory.fillInStorage;
import static com.solvd.library.visitors.ChangeVisitorData.changeVisitorData;

public class Main {
    public static void main(String[] args) {
        fillInStorage();
        Removal remove = new Removal();
        System.out.println("Добро пожаловать");
        Card card = new Auth().auth();
        System.out.println("В систему вошел пользователь: " + card.getVisitor());
        System.out.println(card);
        boolean exit = false;
        while (!exit) {
            System.out.println("Что вы хотите сделать?");
            System.out.println("1. Взять книгу ");
            System.out.println("2. Сдать книгу ");
            System.out.println("3. Взять журнал, газету или комиксы ");
            System.out.println("4. Удалить себя из базы данных ");
            System.out.println("5. Уйти из библиотеки");
            System.out.println("6. Изменить данные");
            Scanner scan = new Scanner(System.in);
            int i = scan.nextInt();
            switch (i) {
                case 1 -> {
                    Book book = new Suggestion().suggest(card);
                    if (book == null) {
                        System.out.println("Пользователю " + card.getVisitor().getName() + " ничего не выдано");
                    } else {
                        System.out.println("Взята " + book);
                    }
                    System.out.println(card);
                }
                case 2 -> {
                    Book books = new Adding().returnAndTakeBook(card);
                    if (books == null) {
                        System.out.println("Пользователю " + card.getVisitor().getName() + " ничего не выдано");
                    } else {
                        System.out.println("Взята " + books);
                    }
                    System.out.println(card);
                }
                case 3 -> {
                    Periodicals periodical = new Giveaway().giveaway();
                    if (periodical == null) {
                        System.out.println("Пользователю " + card.getVisitor().getName() + " ничего не выдано");
                    } else {
                        System.out.println("Пользователю " + card.getVisitor().getName() + " выдано: " + periodical);
                        card.setPeriodicals(periodical);
                        System.out.println(card);
                    }
                }
                case 4 -> {
                    Visitor person = remove.remove(card.getVisitor());
                    System.out.println("Пользователь с номером телефона " + person.getPhone() + " удален");
                }
                case 5 -> {
                    if (card.getPeriodicals() != null) {
                        System.out.println("У вас не сдана периодика " + card.getPeriodicals().getName());
                        card.getPeriodicals().returnPeriodicals();
                    }
                    exit = true;
                    System.out.println("Всего хорошего");
                }
                case 6 -> {
                    changeVisitorData(card.getVisitor());
                    System.out.println("Данные изменены");
                    System.out.println(card.getVisitor());
                }
            }
        }
        System.out.println("Выход из программы");
    }
}