package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.books.Book;
import com.solvd.library.books.Genre;
import com.solvd.library.others.Comics;

import java.lang.reflect.*;
import java.util.Arrays;

import static com.solvd.library.storage.BooksFactory.addBook;
import static com.solvd.library.storage.ComicsFactory.addComics;
import static com.solvd.library.storage.books_information.BooksGeneration.returnArgsForBookInstance;
import static com.solvd.library.storage.books_information.ComicsGeneration.returnNameOfRandomComics;
import static com.solvd.library.utils.GetInformationFromClassUtil.getInformationFromClass;

public class MenuAddBookToLibrary {
    static final MyLogger logger = MyLogger.getInstance();
    private static final Class<?>[] PARAMS_FOR_BOOK_CONSTRUCTOR = new Class[]{String.class, String.class, int.class, Genre.class};
    private static final Class<?>[] PARAMS_FOR_COMICS_METHOD = new Class[]{String.class};

    public static void addBookWithReflection() {
        Class<?> bookClass = getInformationFromClass(Book.class.getName());
        try {
            Constructor<?> newBookConstructor = bookClass.getDeclaredConstructor(PARAMS_FOR_BOOK_CONSTRUCTOR);
            Parameter[] params = newBookConstructor.getParameters();
            Object[] constructorArgs = returnArgsForBookInstance(params.length);
            Book newBook = (Book) newBookConstructor.newInstance(constructorArgs);
            logger.info("Создана книга " + newBook);
            addBook(newBook);
            Method method = bookClass.getDeclaredMethod("returnBook");
            method.invoke(newBook);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
            logger.warn(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    public static void addComicsWithReflection() {
        Class<?> comicsClass = getInformationFromClass(Comics.class.getName());
        try {
            Constructor<?>[] constructors = comicsClass.getDeclaredConstructors();
            for (Constructor<?> constructor: constructors) {
                Class<?>[] parameters = constructor.getParameterTypes();
                Object[] args = new Object[parameters.length];
                int i =0;
                for (Class<?> parameter: parameters) {
                    if (parameter.equals(String.class)) {
                        args[i] = returnNameOfRandomComics();
                        i++;
                    } else if (parameter.equals(Genre.class)) {
                        args[i] = Genre.chooseRandomGenre();
                        i++;
                    }
                }
                Comics comics = (Comics) constructor.newInstance(args);
                logger.info("Создан комикс " + comics);
                Method[] methods = comicsClass.getDeclaredMethods();
                for (Method method: methods) {
                    if (Arrays.equals(method.getParameterTypes(), PARAMS_FOR_COMICS_METHOD)) {
                        method.invoke(comics, returnNameOfRandomComics());
                    }
                }
                logger.info("Имя комикса изменено " + comics);
                addComics(comics);
            }
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException ex) {
            logger.warn(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}
