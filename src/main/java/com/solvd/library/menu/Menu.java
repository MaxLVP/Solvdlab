package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.authentificaation.Auth;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.GenreNotFoundException;
import com.solvd.library.exceptions.PeriodicalNotFoundException;

import java.util.Scanner;
import java.util.function.ToIntFunction;

import static com.solvd.library.library.ReturnPeriodicals.returnPeriodical;
import static com.solvd.library.menu.MenuAddBookToLibrary.addBookWithReflection;
import static com.solvd.library.menu.MenuAddBookToLibrary.addComicsWithReflection;
import static com.solvd.library.menu.MenuChangeData.changeVisitorDataMenu;
import static com.solvd.library.menu.MenuChangeVisitor.changeVisitor;
import static com.solvd.library.menu.MenuExitLibrary.exitLibrary;
import static com.solvd.library.menu.MenuGetSize.getBooksFromGenre;
import static com.solvd.library.menu.MenuGetSize.getSizeOfLibrary;
import static com.solvd.library.menu.MenuRemoveVisitor.removeVisitor;
import static com.solvd.library.menu.MenuReturnBook.returnBook;
import static com.solvd.library.menu.MenuReturnComics.returnComics;
import static com.solvd.library.menu.MenuTakeBook.takeBook;
import static com.solvd.library.menu.MenuTakeComics.takeComics;
import static com.solvd.library.menu.MenuTakePeriodical.takePeriodical;

public class Menu {
    static final MyLogger LOGGER = MyLogger.getInstance();

    public static boolean menu(Card card, Auth authentication, boolean exit) throws GenreNotFoundException, PeriodicalNotFoundException {
        LOGGER.info("Что вы хотите сделать?");
        LOGGER.info("1. Взять книгу ");
        LOGGER.info("2. Сдать книгу ");
        LOGGER.info("3. Взять комикс");
        LOGGER.info("4. Вернуть комикс");
        LOGGER.info("5. Взять переодику");
        LOGGER.info("6. Вернуть периодику");
        LOGGER.info("7. Изменить свои данные");
        LOGGER.info("8. Удалить себя из базы данных ");
        LOGGER.info("9. Выйти из системы");
        LOGGER.info("10. Узнать общее количество книг");
        LOGGER.info("11. Получить информацию по наличию книг любимого жанра");
        LOGGER.info("12. Добавить новую книгу в библиотеку");
        LOGGER.info("13. Добавить новый комикс в библиотеку");
        LOGGER.info("14. Уйти из библиотеки");
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
            case 11 -> getBooksFromGenre(card);
            case 12 -> addBookWithReflection();
            case 13 -> addComicsWithReflection();
            case 14 -> exit = exitLibrary(card);
        }
        return exit;
    }
}
