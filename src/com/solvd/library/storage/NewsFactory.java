package com.solvd.library.storage;

import com.solvd.library.others.Newspaper;

import java.util.PriorityQueue;

public class NewsFactory {
    private final static PriorityQueue<Newspaper> NEWS = new PriorityQueue<>();

    public static void fillInNews() {
        NEWS.add(new Newspaper(1,"Finance times", "Economic"));
        NEWS.add(new Newspaper(2, "New York Times", "Politic"));
        NEWS.add(new Newspaper(3, "Washington Post", "All"));
        NEWS.add(new Newspaper(4, "The Athletic", "Sport"));
    }

    public static Newspaper getNews() {
        fillInNews();
        return NEWS.poll();
    }
}
