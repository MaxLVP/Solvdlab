package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.authentificaation.Auth;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.GenreNotFoundException;
import com.solvd.library.exceptions.PeriodicalNotFoundException;

import java.util.Scanner;

import static com.solvd.library.menu.MenuChangeData.changeVisitorDataMenu;
import static com.solvd.library.menu.MenuChangeVisitor.changeVisitor;
import static com.solvd.library.menu.MenuExitLibrary.exitLibrary;
import static com.solvd.library.menu.MenuRemoveVisitor.removeVisitor;
import static com.solvd.library.menu.MenuReturnBook.returnBook;
import static com.solvd.library.menu.MenuReturnComics.returnComics;
import static com.solvd.library.menu.MenuTakeBook.takeBook;
import static com.solvd.library.menu.MenuTakeComics.takeComics;
import static com.solvd.library.menu.MenuTakePeriodical.takePeriodical;
import static com.solvd.library.storage.BooksFactory.getSizeofLibrary;

public class Menu {
    static final MyLogger logger = MyLogger.getInstance();

    public static boolean menu(Card card, Auth authentication, boolean exit) throws GenreNotFoundException, PeriodicalNotFoundException {
        logger.info("Что вы хотите сделать?");
        logger.info("1. Взять книгу ");
        logger.info("2. Сдать книгу ");
        logger.info("3. Взять журнал, газету или методичку ");
        logger.info("4. Удалить себя из базы данных ");
        logger.info("5. Изменить данные");
        logger.info("6. Взять комикс");
        logger.info("7. Вернуть комикс");
        logger.info("8. Выйти из системы");
        logger.info("9. Узнать общее количество книг");
        logger.info("10. Уйти из библиотеки");
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        switch (i) {
            case 1 -> takeBook(card);
            case 2 -> returnBook(card);
            case 3 -> takePeriodical(card);
            case 4 -> removeVisitor(card);
            case 5 -> changeVisitorDataMenu(card);
            case 6 -> takeComics(card);
            case 7 -> returnComics(card);
            case 8 -> changeVisitor(card, authentication);
            case 9 -> getSizeofLibrary();
            case 10 -> exit = exitLibrary(card);
        }
        return exit;
    }
}
