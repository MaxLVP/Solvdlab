package com.solvd.library.visitors;

import com.solvd.library.MyLogger;
import com.solvd.library.utils.IReturnObject;

import java.util.Scanner;

public class ChangeVisitorData {
    static final MyLogger logger = MyLogger.getInstance();

    public static Visitor changeVisitorData(Visitor visitor) {
        Scanner scanner = new Scanner(System.in);
        IReturnObject<String> ret = () -> {
            logger.info("Что хотите изменить? (телефон, жанр)");
            return scanner.nextLine();
        };
        String type = "";
        if (scanner.hasNextLine()) {
            type = ret.get();
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
