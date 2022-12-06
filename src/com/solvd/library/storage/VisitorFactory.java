package com.solvd.library.storage;

import com.solvd.library.MyLogger;
import com.solvd.library.visitors.Visitor;

import java.util.HashSet;

public class VisitorFactory {
    private final static HashSet<Visitor> VISITORS = new HashSet<>();
    static final MyLogger logger = MyLogger.getInstance();

    public void fillInVisitors() {
        VISITORS.add(new Visitor("Стивен", "+123456", "Кинг", "ужасы"));
    }

    public HashSet<Visitor> getVisitors() {
        return VISITORS;
    }

    public static Visitor addVisitor(Visitor visitor) {
        VISITORS.add(visitor);
        return visitor;
    }

    public static void removeVisitor(Visitor visitor) {
        for (Visitor persons : VISITORS) {
            if (visitor.getPhone().equals(persons.getPhone())) {
                VISITORS.remove(visitor);
                logger.info("Пользователь удален");
            }
            else {
                logger.warn("Такого пользователя не существует");
            }
        }
    }

    public Visitor chooseVisitor(String phone) {
        for (Visitor visitor : VISITORS) {
            if (visitor.getPhone().equals(phone)) {
                return visitor;
            }
        }
        return null;
    }
}
