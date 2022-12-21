package com.solvd.library.utils.custom_lambda;

@FunctionalInterface
public interface IReturnGenre<T, R> {

    R returnGenre(T t);
}
