package com.solvd.library.storage.books_information;

import java.util.List;
import java.util.stream.Stream;

import static com.solvd.library.utils.RandomUtils.returnRandomObjectFromList;

public class BooksGeneration {

    public static String returnNameOfRandomBook() {
        List<String> names = Stream.of("1984", "Война и мир", "Человек-неведимка", "Звук и ярость", "Черный обелиск", "Гордость и предубеждение", "Унесенные ветром", "Три товарища", "Сто лет одиночества").toList();
        return returnRandomObjectFromList(names);
    }

    public static String returnAuthorOfRandomBook() {
        List<String> names = Stream.of("Джордж Оруэлл", "Лев Толстой", "Герберт Уэллс", "Уильям Фолкнер", "Эрих Мария Реирак", "Джейн Остин", "Маргарет Митчелл", "Эрих Мария Ремарк", "Габриэль Гарсиа Маркес").toList();
        return returnRandomObjectFromList(names);
    }
}
