package com.solvd.library.storage;

import com.solvd.library.MyLogger;
import com.solvd.library.others.Magazine;
import com.solvd.library.utils.custom_lambda.IConvert;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;

public class MagazinesFactory {
    static final MyLogger LOGGER = MyLogger.getInstance();
    private static final MyLinkedList<Magazine> LIST = new MyLinkedList<>();

    public static void fillInMagazines() {
        LIST.add(new Magazine("Максим", "Мода"));
        LIST.add(new Magazine("Дом", "Архитектура"));
        LIST.add(new Magazine("Авторевю", "Автомобили"));
    }
    public static void addMagazine(Magazine mag) {
        LIST.add(0, mag);
    }

    public static Magazine getMagazine(String name) {
        Optional<Magazine> magazineName = LIST.stream().filter(magazine -> magazine.getName().equals(name)).findFirst();
        if (magazineName.isEmpty()) {
            return null;
        }
        LIST.remove(magazineName.get());
        return magazineName.get();
    }

    public static void printMagazinesNames() {
        List<String> magazinesNames = LIST.stream().map(magazine ->
                new Magazine(StringUtils.upperCase(magazine.getName()), magazine.getTopic()).toString()).toList();
        LOGGER.info("Журналы: " + magazinesNames);
    }

    public static void printMagazinesCount() {
        IConvert<Integer, String> convert = Object::toString;
        LOGGER.info("Количество журналов: " + convert.convert(LIST.size()));
    }
}
