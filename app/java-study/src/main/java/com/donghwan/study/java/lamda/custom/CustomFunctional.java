package com.donghwan.study.java.lamda.custom;

@FunctionalInterface
public interface CustomFunctional<T> {

    T formatting(T input);
}
