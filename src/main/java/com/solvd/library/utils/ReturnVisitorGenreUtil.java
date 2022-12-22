package com.solvd.library.utils;

import com.solvd.library.MyLogger;
import com.solvd.library.books.Genre;
import com.solvd.library.utils.custom_lambda.IReturnGenre;
import com.solvd.library.visitors.Visitor;

public class ReturnVisitorGenreUtil {
    static final MyLogger LOGGER = MyLogger.getInstance();

    public static Genre returnGenre(Visitor visitor) {
        IReturnGenre<Visitor, Genre> returnGenre = (vis) -> {
            LOGGER.info("Любимый жанр пользователя: " + vis.getGenre());
            return vis.getGenre();
        };
        return returnGenre.returnGenre(visitor);
    }
}
