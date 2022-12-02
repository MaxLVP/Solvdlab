package com.solvd.library.visitors;

import static com.solvd.library.storage.VisitorFactory.removeVisitor;

public class Removal {

    public Visitor remove(Visitor person) {
        removeVisitor(person);
        return person;
    }
}
