package com.solvd.library.storage;

import com.solvd.library.visitors.Visitor;

import java.util.ArrayList;

public class VisitorFactory {
    private final static ArrayList<Visitor> LIST = new ArrayList<>();

    public void fillInVisitors() {
        LIST.add(new Visitor("Стивен", "+123456", "Кинг", "ужасы"));
    }

    public ArrayList<Visitor> getLIST() {
        return LIST;
    }

    public static Visitor addVisitor(Visitor visitor) {
        LIST.add(visitor);
        return visitor;
    }

    public static void removeVisitor(Visitor visitor) {
        for (Visitor persons : LIST) {
            if (visitor.getPhone().equals(persons.getPhone())) {
                LIST.remove(visitor);
                System.out.println("Пользователь удален");
            }
            else {
                System.out.println("Такого пользователя не существует");
            }
        }
    }

    public Visitor chooseVisitor(String phone) {
        for (Visitor visitor : LIST) {
            if (visitor.getPhone().equals(phone)) {
                return visitor;
            }
        }
        return null;
    }
}
