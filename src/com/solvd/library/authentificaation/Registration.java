package com.solvd.library.authentificaation;

import com.solvd.library.visitors.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class Registration {

    public Person register(String phone) {
        System.out.println("Введите имя, фамилию и предпочитаемый жанр");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> info = new ArrayList<>();
        String current = scanner.nextLine();
        while (!current.equals("")) {
            info.add(current);
            current = scanner.nextLine();
        }
        Person person = new Person(info.get(0), phone, info.get(1), info.get(2));
        System.out.println("Пользователь " + person.getName() + " " + person.getSecondName() + " " +
                "зарегистрирован, номер телефона: " + person.getPhone());
        return person;
    }
}
