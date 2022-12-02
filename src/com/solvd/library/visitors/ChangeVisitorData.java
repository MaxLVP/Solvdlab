package com.solvd.library.visitors;

import java.util.Scanner;

public class ChangeVisitorData {

    public static Visitor changeVisitorData(Visitor visitor) {
        System.out.println("Что хотите изменить? (телефон, жанр)");
        Scanner scanner = new Scanner(System.in);
        String type = "";
        if (scanner.hasNextLine()) {
            type = scanner.nextLine();
        } else {
            System.out.println("Вы не ввели что хотите получить");
        }
        switch (type) {
            case "телефон" -> {
                System.out.println("Введите новый телефон");
                String phone = scanner.nextLine();
                visitor.setPhone(phone);
                return visitor;
            }
            case "жанр" -> {
                System.out.println("Введите новый жанр");
                String genre = scanner.nextLine();
                visitor.setPhone(genre);
                return visitor;
            }
            default -> {
                System.out.println("Вы ничего не ввели");
                return visitor;
            }
        }
    }
}
