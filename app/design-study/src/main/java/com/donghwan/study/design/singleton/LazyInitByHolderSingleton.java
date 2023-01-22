package com.donghwan.study.design.singleton;

public class LazyInitByHolderSingleton {

    private LazyInitByHolderSingleton() {

    }

    public static LazyInitByHolderSingleton getInstance() {
        return Holder.LAZY_INIT_BY_HOLDER_SINGLETON;
    }

    private static class Holder {

        private static final LazyInitByHolderSingleton LAZY_INIT_BY_HOLDER_SINGLETON = new LazyInitByHolderSingleton();
    }
}