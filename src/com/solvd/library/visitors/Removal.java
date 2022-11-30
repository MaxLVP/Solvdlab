package com.solvd.library.visitors;

import static com.solvd.library.visitors.PersonData.removePerson;

public class Removal {

    public Visitor remove(Visitor person) {
        removePerson(person);
        return person;
    }
}
