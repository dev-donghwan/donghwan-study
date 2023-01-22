package com.donghwan.study.design.singleton;

public class LazyInitSingleton {

    private static LazyInitSingleton instance;

    private LazyInitSingleton() {

    }

    public static LazyInitSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitSingleton();
        }

        return instance;
    }
}
