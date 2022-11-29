package com.solvd.library.authentificaation;

import com.solvd.library.cards.Card;
import com.solvd.library.storage.DetectiveBooks;
import com.solvd.library.storage.FantasyBooks;
import com.solvd.library.storage.HorrorBooks;
import com.solvd.library.visitors.Person;

import java.util.Scanner;

public class Auth {

    public Card auth() {
        System.out.println("Введите номер телефона");
        Scanner scanner = new Scanner(System.in);
        String phone = scanner.nextLine();
        Card card = new Login().login(phone);
        if (card == null) {
            System.out.println("Вы не зарегистрированы, пройдите регистрацию");
            Person person = new Registration().register(phone);
            card = new Card(person, null, null);
        }
        return card;
    }
}
