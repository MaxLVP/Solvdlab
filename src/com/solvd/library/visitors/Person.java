package com.solvd.library.visitors;

import java.util.Objects;

public class Person {
    private String name;
    private String phone;
    private String secondName;
    private String genre;

    public Person(String name, String phone, String secondName, String genre) {
        this.name = name;
        this.phone = phone;
        this.secondName = secondName;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String setGenre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(phone, person.phone) && Objects.equals(secondName, person.secondName) && Objects.equals(genre, person.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, secondName, genre);
    }

    @Override
    public String toString() {
        return "Посетитель " + name + " " + secondName +
                ", телефон: " + phone + ", любимый жанр: '" +
                genre + '\'';
    }
}
