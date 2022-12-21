package com.solvd.library.utils.custom_lambda;

@FunctionalInterface
public interface IConvert<T, R> {

    R convert(T t);
}
