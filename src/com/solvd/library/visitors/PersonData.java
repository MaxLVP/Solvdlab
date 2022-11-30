package com.solvd.library.visitors;

import java.util.ArrayList;

public class PersonData {
    private final static ArrayList<Visitor> LIST = new ArrayList<>();

    public void fillInPerson() {
        LIST.add(new Visitor("Адам", "+325698", "Невилл", "фэнтэзи"));
        LIST.add(new Visitor("Стивен", "+123456", "Кинг", "ужасы"));
        LIST.add(new Visitor("Гари", "+987456", "Дойл", "детектив"));
        LIST.add(new Visitor("Джон", "+456231", "Хиг", "фэнтэзи"));
        LIST.add(new Visitor("Джейми", "+654123", "Спенсер", "детектив"));
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
