package com.solvd.library.authentificaation;

import com.solvd.library.MyLogger;
import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.PersonNotFoundException;
import com.solvd.library.visitors.Visitor;

import java.util.Scanner;

public class Auth {
    static final MyLogger logger = MyLogger.getInstance();

    public Card auth() {
        logger.info("Введите номер телефона");
        Scanner scanner = new Scanner(System.in);
        String phone = scanner.nextLine();
        try {
            return new Login().login(phone);
        } catch (PersonNotFoundException ex) {
            logger.warn(ex.getMessage());
            logger.info("Вы не зарегистрированы, пройдите регистрацию");
            Visitor person = new Registration().register(phone);
            return new Card(person, null, null, null);
        }
    }
}
