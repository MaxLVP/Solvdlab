package com.solvd.library.storage;

import com.solvd.library.MyLogger;
import com.solvd.library.books.Book;
import com.solvd.library.books.Genre;
import com.solvd.library.exceptions.LibraryBooksNotFound;
import com.solvd.library.visitors.Visitor;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static com.solvd.library.utils.RandomUtils.returnRandomIntWithSize;

public class BooksFactory {
    private final static ArrayList<Book> BOOK_LIST = new ArrayList<>();
    static final MyLogger LOGGER = MyLogger.getInstance();

    public static void fillInStorage() {
        BOOK_LIST.add(new Book("Смерть на Ниле", "Агата Кристи", 340, Genre.DETECTIVE));
        BOOK_LIST.add(new Book("Восточный экспресс", "Агата Кристи", 300, Genre.DETECTIVE));
        BOOK_LIST.add(new Book("Шерлок Холмс", "Артур Конан Дойл", 400, Genre.DETECTIVE));
        BOOK_LIST.add(new Book("Код да Винчи", "Дэн Браун", 500, Genre.DETECTIVE));
        BOOK_LIST.add(new Book("Десять нигретят", "Агата Кристи", 250, Genre.DETECTIVE));
        BOOK_LIST.add(new Book("Властелин колец", "Джон Толкин", 700, Genre.FANTASY));
        BOOK_LIST.add(new Book("Гарри Поттер", "Джоан Роулинг", 300, Genre.FANTASY));
        BOOK_LIST.add(new Book("Ведьмак", "Анджей Сапковски", 400, Genre.FANTASY));
        BOOK_LIST.add(new Book("Игра престолов", "Джордж Мартин", 500, Genre.FANTASY));
        BOOK_LIST.add(new Book("Волшебник Земноморья", "Урсула ле Гуин", 250, Genre.FANTASY));
        BOOK_LIST.add(new Book("Оно", "Стивен Кинг", 340, Genre.HORROR));
        BOOK_LIST.add(new Book("Мифы Ктулху", "Говард Лавкрафт", 300, Genre.HORROR));
        BOOK_LIST.add(new Book("Мертвая зона", "Стивен Кинг", 400, Genre.HORROR));
        BOOK_LIST.add(new Book("Красный дракон", "Томас Харрис", 500, Genre.HORROR));
        BOOK_LIST.add(new Book("Ритуал", "Адам Нэвилл", 250, Genre.HORROR));
        BOOK_LIST.add(new Book("Три мушкетера", "Александр Дюма", 800, Genre.ADVENTURE));
        BOOK_LIST.add(new Book("Робинзон Крузо", "Даниэль Дефо", 500, Genre.ADVENTURE));
        BOOK_LIST.add(new Book("Таинственный остров", "Жюль Верн", 400, Genre.ADVENTURE));
        BOOK_LIST.add(new Book("Приключения Тома Сойера", "Марк Твен", 600, Genre.ADVENTURE));
        BOOK_LIST.add(new Book("Алиса в Зазеркалье", "Льюис Кэрролл", 450, Genre.ADVENTURE));
        BOOK_LIST.add(new Book("451 градус по Фаренгейту", "Рэй Бэдберри", 400, Genre.FANTASTIC));
        BOOK_LIST.add(new Book("Машина времени", "Герберт Уэллс", 500, Genre.FANTASTIC));
        BOOK_LIST.add(new Book("Цветы для Элджерона", "Дэниал Киз", 400, Genre.FANTASTIC));
        BOOK_LIST.add(new Book("Путешествие к центру Земли", "Жюль Верн", 500, Genre.FANTASTIC));
        BOOK_LIST.add(new Book("Темная башня", "Стивен Кинг", 450, Genre.FANTASTIC));
    }

    public static void addBook(Book book) {
        BOOK_LIST.add(book);
    }

    public static Book chooseBook(Genre genre) {
        List<Book> genreBooks = BOOK_LIST.stream().filter(book -> book.getGenre() == genre).toList();
        try {
            Book book = chooseBookForGenre(genreBooks);
            BOOK_LIST.remove(book);
            return book;
        } catch (LibraryBooksNotFound ex) {
            LOGGER.warn(ex.getMessage());
            return null;
        }
    }

    public static Book chooseBookForGenre(List<Book> genreBooks) throws LibraryBooksNotFound {
        if (genreBooks.size() == 0) {
            throw new LibraryBooksNotFound();
        }
        return genreBooks.get(returnRandomIntWithSize(genreBooks.size()));
    }

    public static void getAllBooks() {
        LOGGER.info(BOOK_LIST);
    }

    public static void getBooksNames(Visitor visitor) {
        List<ArrayList<String>> booksNames = BOOK_LIST.stream().filter(book -> book.getGenre().equals(visitor.getGenre()))
                .map(book -> new ArrayList<>(Arrays.asList(StringUtils.capitalize(book.getName()), book.getAuthor()))).toList();
        LOGGER.info("Книги доступные по вашему жанру: " + booksNames);
    }

    public static void getBooksCount() {
        Function<Integer, String> convert = String::valueOf;
        LOGGER.info("Общее количество книг: " + convert.apply(BOOK_LIST.size()));
    }

}
