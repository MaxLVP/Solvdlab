package com.solvd.library.visitors;

public class Removal {

    public Person remove(Person person) {
        System.out.println("Пользователь с телефоном: " + person.getPhone() + " удален");
        return person;
    }
}
