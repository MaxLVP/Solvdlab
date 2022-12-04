package com.solvd.library.menu;

import com.solvd.library.cards.Card;

import java.util.Scanner;

import static com.solvd.library.menu.MenuRemoveVisitor.removeVisitor;
import static com.solvd.library.menu.MenuReturnBook.returnBook;
import static com.solvd.library.menu.MenuTakeBook.takeBook;
import static com.solvd.library.menu.MenuTakePeriodical.takePeriodical;
import static com.solvd.library.visitors.ChangeVisitorData.changeVisitorData;

public class Menu {

    public static boolean menu(Card card, boolean exit) {
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
            case 1 -> takeBook(card);
            case 2 -> returnBook(card);
            case 3 -> takePeriodical(card);
            case 4 -> removeVisitor(card);
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
        return exit;
    }
}
