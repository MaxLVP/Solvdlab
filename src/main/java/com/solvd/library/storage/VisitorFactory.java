package com.solvd.library.storage;

import com.solvd.library.MyLogger;
import com.solvd.library.visitors.Visitor;

import java.util.HashSet;
import java.util.Optional;

public class VisitorFactory {
    private final static HashSet<Visitor> VISITORS = new HashSet<>();
    static final MyLogger logger = MyLogger.getInstance();

    public static void fillInVisitors() {
        VISITORS.add(new Visitor("Стивен", "+123456", "Кинг", "ужасы"));
    }

    public static HashSet<Visitor> getVisitors() {
        return VISITORS;
    }

    public static Visitor addVisitor(Visitor visitor) {
        VISITORS.add(visitor);
        return visitor;
    }

    public static void removeVisitor(Visitor visitor) {
        Optional<Visitor> removeVisitor = VISITORS.stream().filter(person -> person.getPhone().equals(visitor.getPhone())).findFirst();
        if (removeVisitor.isPresent()) {
            VISITORS.remove(removeVisitor.get());
            logger.info("Пользователь удален");
        } else {
            logger.warn("Такого пользователя не существует");
        }
    }

    public static Visitor chooseVisitor(String phone) {
        for (Visitor visitor : VISITORS) {
            if (visitor.getPhone().equals(phone)) {
                return visitor;
            }
        }
        return null;
    }
}
