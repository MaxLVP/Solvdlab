package com.solvd.library.storage.books_information;

import java.util.List;
import java.util.stream.Stream;

import static com.solvd.library.utils.RandomUtils.returnRandomObjectFromList;

public class ComicsGeneration {

    public static String returnNameOfRandomComics() {
        List<String> names = Stream.of("Хранители", "Ходячие мертвецы", "Скотт Пилигрим", "Песочный человек", "Трансметрополитен",
                "Маус", "Город грехов", "Одеяла", "Я убиваю великанов").toList();
        return returnRandomObjectFromList(names);
    }
}
