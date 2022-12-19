package com.solvd.library.utils;

@FunctionalInterface
public interface IReturnGenre<T, R> {

    R returnGenre(T t);
}
