package com.solvd.library.visitors;

import com.solvd.library.MyLogger;
import com.solvd.library.utils.custom_lambda.IReturnObject;

import java.util.Scanner;

public class ChangeVisitorData {
    static final MyLogger LOGGER = MyLogger.getInstance();

    public static void changeVisitorData(Visitor visitor) {
        Scanner scanner = new Scanner(System.in);
        IReturnObject<String> ret = () -> {
            LOGGER.info("Что хотите изменить? (телефон, жанр)");
            return scanner.nextLine();
        };
        String type = "";
        if (scanner.hasNextLine()) {
            type = ret.get();
        } else {
            LOGGER.info("Вы не ввели что хотите получить");
        }
        switch (type) {
            case "телефон" -> {
                LOGGER.info("Введите новый телефон");
                String phone = scanner.nextLine();
                visitor.setPhone(phone);
            }
            case "жанр" -> {
                LOGGER.info("Введите новый жанр (ужасы, детектив, приключения, фантастика, фэнтэзи)");
                String genre = scanner.nextLine();
                visitor.setGenre(genre);
            }
            default -> LOGGER.warn("Вы ничего не ввели");
        }
    }
}
