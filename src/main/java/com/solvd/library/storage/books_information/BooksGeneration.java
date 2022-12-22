package com.solvd.library.storage.books_information;

import com.solvd.library.books.Genre;

import java.util.List;
import java.util.stream.Stream;

import static com.solvd.library.utils.RandomUtils.returnRandomIntInRange;
import static com.solvd.library.utils.RandomUtils.returnRandomObjectFromList;

public class BooksGeneration {
    private static final int START_PAGE = 90;
    private static final int END_PAGE = 1000;

    public static String returnNameOfRandomBook() {
        List<String> names = Stream.of("1984", "Война и мир", "Человек-невидимка", "Звук и ярость", "Черный обелиск", "Гордость и предубеждение", "Унесенные ветром", "Три товарища", "Сто лет одиночества").toList();
        return returnRandomObjectFromList(names);
    }

    public static String returnAuthorOfRandomBook() {
        List<String> names = Stream.of("Джордж Оруэлл", "Лев Толстой", "Герберт Уэллс", "Уильям Фолкнер", "Эрих Мария Реирак", "Джейн Остин", "Маргарет Митчелл", "Эрих Мария Ремарк", "Габриэль Гарсиа Маркес").toList();
        return returnRandomObjectFromList(names);
    }

    public static Object[] returnArgsForBookInstance(int size) {
        Object[] args = new Object[size];
        args[0] = returnNameOfRandomBook();
        args[1] = returnAuthorOfRandomBook();
        args[2] = returnRandomIntInRange(START_PAGE, END_PAGE);
        args[3] = Genre.chooseRandomGenre();
        return args;
    }
}
