package com.solvd.library.authentificaation;

import com.solvd.library.cards.Card;
import com.solvd.library.visitors.Visitor;

import java.util.Scanner;

public class Auth {

    public Card auth() {
        System.out.println("Введите номер телефона");
        Scanner scanner = new Scanner(System.in);
        String phone = scanner.nextLine();
        Card card = new Login().login(phone);
        if (card == null) {
            System.out.println("Вы не зарегистрированы, пройдите регистрацию");
            Visitor person = new Registration().register(phone);
            card = new Card(person, null, null);
        }
        return card;
    }
}
