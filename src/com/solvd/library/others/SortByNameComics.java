package com.solvd.library.others;

import java.util.Comparator;

public class SortByNameComics implements Comparator<Comics> {

    @Override
    public int compare(Comics o1, Comics o2) {
        return o1.getGenre().compareTo(o2.getGenre());
    }
}
