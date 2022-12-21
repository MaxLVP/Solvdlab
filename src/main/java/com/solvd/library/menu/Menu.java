package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.authentificaation.Auth;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.GenreNotFoundException;
import com.solvd.library.exceptions.PeriodicalNotFoundException;

import java.util.Scanner;
import java.util.function.ToIntFunction;

import static com.solvd.library.library.ReturnPeriodicals.returnPeriodical;
import static com.solvd.library.menu.MenuAddBookToLibrary.addBook;
import static com.solvd.library.menu.MenuChangeData.changeVisitorDataMenu;
import static com.solvd.library.menu.MenuChangeVisitor.changeVisitor;
import static com.solvd.library.menu.MenuExitLibrary.exitLibrary;
import static com.solvd.library.menu.MenuGetSize.getSizeOfLibrary;
import static com.solvd.library.menu.MenuRemoveVisitor.removeVisitor;
import static com.solvd.library.menu.MenuReturnBook.returnBook;
import static com.solvd.library.menu.MenuReturnComics.returnComics;
import static com.solvd.library.menu.MenuTakeBook.takeBook;
import static com.solvd.library.menu.MenuTakeComics.takeComics;
import static com.solvd.library.menu.MenuTakePeriodical.takePeriodical;

public class Menu {
    static final MyLogger logger = MyLogger.getInstance();

    public static boolean menu(Card card, Auth authentication, boolean exit) throws GenreNotFoundException, PeriodicalNotFoundException {
        logger.info("Что вы хотите сделать?");
        logger.info("1. Взять книгу ");
        logger.info("2. Сдать книгу ");
        logger.info("3. Взять комикс");
        logger.info("4. Вернуть комикс");
        logger.info("5. Взять переодику");
        logger.info("6. Вернуть периодику");
        logger.info("7. Изменить свои данные");
        logger.info("8. Удалить себя из базы данных ");
        logger.info("9. Выйти из системы");
        logger.info("10. Узнать общее количество книг");
        logger.info("11. Добавить новую книгу в библиотеку");
        logger.info("12. Уйти из библиотеки");
        Scanner scan = new Scanner(System.in);
        ToIntFunction<String> toIntFunction = Integer::parseInt;
        int i = toIntFunction.applyAsInt(scan.nextLine());
        switch (i) {
            case 1 -> takeBook(card);
            case 2 -> returnBook(card);
            case 3 -> takeComics(card);
            case 4 -> returnComics(card);
            case 5 -> takePeriodical(card);
            case 6 -> returnPeriodical(card.getPeriodicals());
            case 7 -> changeVisitorDataMenu(card);
            case 8 -> removeVisitor(card);
            case 9 -> changeVisitor(card, authentication);
            case 10 -> getSizeOfLibrary();
            case 11 -> addBook();
            case 12 -> exit = exitLibrary(card);
        }
        return exit;
    }
}
