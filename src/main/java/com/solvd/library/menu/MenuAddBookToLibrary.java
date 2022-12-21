package com.solvd.library.menu;

import com.solvd.library.MyLogger;
import com.solvd.library.books.Book;
import com.solvd.library.books.Genre;

import java.lang.reflect.*;

import static com.solvd.library.storage.books_information.BooksGeneration.returnAuthorOfRandomBook;
import static com.solvd.library.storage.books_information.BooksGeneration.returnNameOfRandomBook;
import static com.solvd.library.utils.GetInformationFromClassUtil.getInformationFromClass;
import static com.solvd.library.utils.RandomUtils.returnRandomInt;

public class MenuAddBookToLibrary {
    static final MyLogger logger = MyLogger.getInstance();

    public static void addBook() {
        Class<?> bookClass = getInformationFromClass(Book.class.getName());
        Constructor<?>[] bookConstructors = bookClass.getDeclaredConstructors();
        try {
            for (Constructor<?> constructor: bookConstructors) {
                Parameter[] params = constructor.getParameters();
                Object[] constructorArgs = new Object[params.length];
                int i = 0;
                for (Parameter param: params) {
                    if (param.getType().equals(String.class) & param.getName().contains("0")) {
                        constructorArgs[i] = returnNameOfRandomBook();
                        i++;
                    } else if (param.getType().equals(String.class) & param.getName().contains("1")) {
                        constructorArgs[i] = returnAuthorOfRandomBook();
                        i++;
                    } else if (param.getType().equals(int.class)) {
                        constructorArgs[i] = returnRandomInt();
                        i++;
                    } else if (param.getType().equals(Genre.class)) {
                        constructorArgs[i] = Genre.chooseRandomGenre();
                        i++;
                    }
                }
                Book newBook = (Book) constructor.newInstance(constructorArgs);
                logger.info(newBook);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            logger.warn(ex.getMessage());
        }
    }
}
