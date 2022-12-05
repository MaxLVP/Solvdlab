package com.solvd.library.menu;

import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.GenreNotFoundException;
import com.solvd.library.exceptions.PeriodicalNotFoundException;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import static com.solvd.library.menu.MenuRemoveVisitor.removeVisitor;
import static com.solvd.library.menu.MenuReturnBook.returnBook;
import static com.solvd.library.menu.MenuTakeBook.takeBook;
import static com.solvd.library.menu.MenuTakePeriodical.takePeriodical;
import static com.solvd.library.visitors.ChangeVisitorData.changeVisitorData;

public class Menu {

    public static boolean menu(Card card, boolean exit, Logger logger) throws GenreNotFoundException, PeriodicalNotFoundException {
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
            case 1 -> takeBook(card, logger);
            case 2 -> returnBook(card, logger);
            case 3 -> takePeriodical(card, logger);
            case 4 -> removeVisitor(card, logger);
            case 5 -> {
                if (card.getPeriodicals() != null) {
                    logger.info("У вас не сдана периодика " + card.getPeriodicals().getName());
                    card.getPeriodicals().returnPeriodicals();
                }
                exit = true;
                logger.info("Всего хорошего");
            }
            case 6 -> {
                changeVisitorData(card.getVisitor());
                logger.info("Данные изменены");
                logger.info(card.getVisitor());
            }
        }
        return exit;
    }
}
