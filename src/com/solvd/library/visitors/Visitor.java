package com.solvd.library.visitors;

import java.util.Objects;

public final class Visitor {
    private final String name;
    private String phone;
    private final String secondName;
    private String genre;

    public Visitor(String name, String phone, String secondName, String genre) {
        this.name = name;
        this.phone = phone;
        this.secondName = secondName;
        this.genre = genre;
    }

    public String getName() {
        return name;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Visitor person = (Visitor) o;
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
