package com.solvd.library.visitors;

import java.util.Objects;

public final class Visitor {
    private final String NAME;
    private String phone;
    private final String SECOND_NAME;
    private String genre;

    public Visitor(String name, String phone, String secondName, String genre) {
        this.NAME = name;
        this.phone = phone;
        this.SECOND_NAME = secondName;
        this.genre = genre;
    }

    public String getName() {
        return NAME;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecondName() {
        return SECOND_NAME;
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
        return Objects.equals(NAME, person.NAME) && Objects.equals(phone, person.phone) && Objects.equals(SECOND_NAME, person.SECOND_NAME) && Objects.equals(genre, person.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME, phone, SECOND_NAME, genre);
    }

    @Override
    public String toString() {
        return "Посетитель " + NAME + " " + SECOND_NAME +
                ", телефон: " + phone + ", любимый жанр: '" +
                genre + '\'';
    }
}
