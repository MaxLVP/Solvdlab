package com.solvd.library.visitors;

import java.util.ArrayList;

public class PersonData {
    private final static ArrayList<Visitor> LIST = new ArrayList<>();

    public void fillInPerson() {
        LIST.add(new Visitor("Стивен", "+123456", "Кинг", "ужасы"));
    }

    public ArrayList<Visitor> getLIST() {
        return LIST;
    }

    public static Visitor addPerson(Visitor person) {
        LIST.add(person);
        return person;
    }

    public static void removePerson(Visitor person) {
        for (Visitor persons : LIST) {
            if (person.getPhone().equals(persons.getPhone())) {
                LIST.remove(person);
                System.out.println("Пользователь удален");
            }
            else {
                System.out.println("Такого пользователя не существует");
            }
        }
    }

    public Visitor choosePerson(String phone) {
        for (Visitor person : LIST) {
            if (person.getPhone().equals(phone)) {
                return person;
            }
        }
        return null;
    }
}
