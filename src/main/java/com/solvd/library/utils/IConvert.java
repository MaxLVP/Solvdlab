package com.solvd.library.utils;

@FunctionalInterface
public interface IConvert<T, R> {

    R convert(T t);
}
