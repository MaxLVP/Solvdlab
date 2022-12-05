package com.solvd.library.authentificaation;

import com.solvd.library.cards.Card;
import com.solvd.library.exceptions.PersonNotFoundException;
import com.solvd.library.visitors.Visitor;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Auth {

    public Card auth(Logger logger) {
        logger.info("Введите номер телефона");
        Scanner scanner = new Scanner(System.in);
        String phone = scanner.nextLine();
        try {
            return new Login().login(phone, logger);
        } catch (PersonNotFoundException ex) {
            logger.warn(ex.getMessage());
            logger.info("Вы не зарегистрированы, пройдите регистрацию");
            Visitor person = new Registration().register(phone);
            return new Card(person, null, null);
        }
    }
}
