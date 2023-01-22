package com.donghwan.study.design.singleton;

public class LazyInitWithSyncSingleton {

    private static LazyInitWithSyncSingleton instance;

    private LazyInitWithSyncSingleton() {

    }

    public static synchronized LazyInitWithSyncSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitWithSyncSingleton();
        }

        return instance;
    }
}
