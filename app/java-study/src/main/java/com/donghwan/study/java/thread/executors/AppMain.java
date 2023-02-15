package com.donghwan.study.java.thread.executors;

import java.util.concurrent.Executors;

public class AppMain {

    public static void main(String[] args) {
        Executors.newCachedThreadPool().execute();
    }
}
