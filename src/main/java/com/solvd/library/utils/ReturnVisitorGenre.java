package com.solvd.library.utils;

import com.solvd.library.MyLogger;
import com.solvd.library.visitors.Visitor;

public class ReturnVisitorGenre {
    static final MyLogger logger = MyLogger.getInstance();

    public static String returnGenre(Visitor visitor) {
        IReturnGenre<Visitor, String> returnGenre = (vis) -> {
            logger.info("Любимый жанр пользователя: " + vis.getGenre());
            return vis.getGenre();
        };
        return returnGenre.returnGenre(visitor);
    }
}
