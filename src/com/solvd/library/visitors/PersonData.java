package com.solvd.library.visitors;

import java.util.ArrayList;

public class PersonData {
    private final ArrayList<Person> LIST = new ArrayList<>();

    public void fillInPerson() {
        LIST.add(new Person("Адам", "+325698", "Невилл", "фэнтэзи"));
        LIST.add(new Person("Стивен", "+123456", "Кинг", "ужасы"));
        LIST.add(new Person("Гари", "+987456", "Дойл", "детектив"));
        LIST.add(new Person("Джон", "+456231", "Хиг", "фэнтэзи"));
        LIST.add(new Person("Джейми", "+654123", "Спенсер", "детектив"));
    }

    public ArrayList<Person> getLIST() {
        return LIST;
    }

    public Person choosePerson(String phone) {
        for (Person person : LIST) {
            if (person.getPhone().equals(phone)) {
                return person;
            }
        }
        return null;
    }
}
