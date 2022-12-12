package com.solvd.library.authentificaation;

import com.solvd.library.MyLogger;
import com.solvd.library.visitors.Visitor;

import java.util.ArrayList;
import java.util.Scanner;

import static com.solvd.library.storage.VisitorFactory.addVisitor;

public class Registration {
    static final MyLogger logger = MyLogger.getInstance();

    public Visitor register(String phone) {
        logger.info("Введите имя, фамилию и предпочитаемый жанр (ужасы, детектив, приключения, фантастика, фэнтэзи)");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> info = new ArrayList<>();
        String current = scanner.nextLine();
        while (!current.equals("")) {
            info.add(current);
            current = scanner.nextLine();
        }
        Visitor person = new Visitor(info.get(0), phone, info.get(1), info.get(2));
        addVisitor(person);
        logger.info("Пользователь " + person.getName() + " " + person.getSecondName() + " " +
                "зарегистрирован, номер телефона: " + person.getPhone());
        return person;
    }
}
