package com.solvd.library.authentificaation;

import com.solvd.library.visitors.Visitor;

import java.util.ArrayList;
import java.util.Scanner;

import static com.solvd.library.visitors.PersonData.addPerson;

public class Registration {

    public Visitor register(String phone) {
        System.out.println("Введите имя, фамилию и предпочитаемый жанр (ужасы, детектив, приключения, фантастика, фэнтэзи)");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> info = new ArrayList<>();
        String current = scanner.nextLine();
        while (!current.equals("")) {
            info.add(current);
            current = scanner.nextLine();
        }
        Visitor person = new Visitor(info.get(0), phone, info.get(1), info.get(2));
        addPerson(person);
        System.out.println("Пользователь " + person.getName() + " " + person.getSecondName() + " " +
                "зарегистрирован, номер телефона: " + person.getPhone());
        return person;
    }
}
