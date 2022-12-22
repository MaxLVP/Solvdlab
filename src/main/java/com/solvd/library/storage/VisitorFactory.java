package com.solvd.library.storage;

import com.solvd.library.MyLogger;
import com.solvd.library.books.Genre;
import com.solvd.library.visitors.Visitor;

import java.util.HashSet;
import java.util.Optional;

public class VisitorFactory {
    private final static HashSet<Visitor> VISITORS = new HashSet<>();
    static final MyLogger LOGGER = MyLogger.getInstance();

    public static void fillInVisitors() {
        VISITORS.add(new Visitor("Стивен", "+123456", "Кинг", Genre.HORROR));
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
            LOGGER.info("Пользователь удален");
        } else {
            LOGGER.warn("Такого пользователя не существует");
        }
    }

    public static Visitor chooseVisitor(String phone) {
        Optional<Visitor> neededVisitor = VISITORS.stream().filter(person -> person.getPhone().equals(phone)).findFirst();
        return neededVisitor.orElse(null);
    }
}
