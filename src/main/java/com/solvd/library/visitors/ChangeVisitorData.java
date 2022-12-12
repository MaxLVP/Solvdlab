package com.solvd.library.visitors;

import com.solvd.library.MyLogger;

import java.util.Scanner;

public class ChangeVisitorData {
    static final MyLogger logger = MyLogger.getInstance();

    public static Visitor changeVisitorData(Visitor visitor) {
        logger.info("Что хотите изменить? (телефон, жанр)");
        Scanner scanner = new Scanner(System.in);
        String type = "";
        if (scanner.hasNextLine()) {
            type = scanner.nextLine();
        } else {
            logger.info("Вы не ввели что хотите получить");
        }
        switch (type) {
            case "телефон" -> {
                logger.info("Введите новый телефон");
                String phone = scanner.nextLine();
                visitor.setPhone(phone);
                return visitor;
            }
            case "жанр" -> {
                logger.info("Введите новый жанр (ужасы, детектив, приключения, фантастика, фэнтэзи)");
                String genre = scanner.nextLine();
                visitor.setGenre(genre);
                return visitor;
            }
            default -> {
                logger.warn("Вы ничего не ввели");
                return visitor;
            }
        }
    }
}
