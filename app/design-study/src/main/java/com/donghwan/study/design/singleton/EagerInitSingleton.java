package com.donghwan.study.design.singleton;

public class EagerInitSingleton {

    private static EagerInitSingleton instance = new EagerInitSingleton();

    private EagerInitSingleton() {

    }

    public static EagerInitSingleton getInstance() {
        return instance;
    }
}
