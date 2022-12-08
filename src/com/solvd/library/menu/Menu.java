package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.GenreNotFoundException;
import com.solvd.library.exceptions.PeriodicalNotFoundException;

import java.util.Scanner;

import static com.solvd.library.menu.MenuRemoveVisitor.removeVisitor;
import static com.solvd.library.menu.MenuReturnBook.returnBook;
import static com.solvd.library.menu.MenuTakeBook.takeBook;
import static com.solvd.library.menu.MenuTakeComics.takeComics;
import static com.solvd.library.menu.MenuTakePeriodical.takePeriodical;
import static com.solvd.library.visitors.ChangeVisitorData.changeVisitorData;

public class Menu {
    static final MyLogger logger = MyLogger.getInstance();

    public static boolean menu(Card card, boolean exit) throws GenreNotFoundException, PeriodicalNotFoundException {
        logger.info("Что вы хотите сделать?");
        logger.info("1. Взять книгу ");
        logger.info("2. Сдать книгу ");
        logger.info("3. Взять журнал, газету или методичку ");
        logger.info("4. Удалить себя из базы данных ");
        logger.info("5. Уйти из библиотеки");
        logger.info("6. Изменить данные");
        logger.info("7. Взять комикс");
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        switch (i) {
            case 1 -> takeBook(card);
            case 2 -> returnBook(card);
            case 3 -> takePeriodical(card);
            case 4 -> removeVisitor(card);
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
            case 7 -> {
                takeComics(card);
                logger.info(card);
            }
        }
        return exit;
    }
}
