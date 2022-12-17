package com.solvd.library.utils;

@FunctionalInterface
public interface Convert<T, R> {

    R convert(T t);
}
