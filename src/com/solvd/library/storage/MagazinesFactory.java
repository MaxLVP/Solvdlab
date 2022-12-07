package com.solvd.library.storage;

import com.solvd.library.MyLogger;
import com.solvd.library.others.Magazine;

import java.util.Random;

public class MagazinesFactory {
    static final MyLogger logger = MyLogger.getInstance();
    private static final MyLinkedList<Magazine> LIST = new MyLinkedList<>();

    public static void fillInMagazines() {
        LIST.add(new Magazine("Максим", "Мода"));
        LIST.add(new Magazine("Дом", "Архитектура"));
        LIST.add(new Magazine("Авторевю", "Автомобили"));
    }
    public static void addMagazine(Magazine mag) {
        LIST.add(0, mag);
        logger.info(LIST);
    }

    public static Magazine getMagazine() {
        logger.info(LIST);
        Random random = new Random();
        int index = random.nextInt(LIST.size());
        Magazine magazine = LIST.get(index);
        LIST.remove(magazine);
        logger.info(LIST);
        return magazine;
    }
}
