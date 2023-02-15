package com.donghwan.study.java.thread.executors;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AppMain {

    public static void main(String[] args) {

        List<Callable<Void>> mock = IntStream.range(1, 10)
            .boxed()
            .map(x -> (Callable<Void>) () -> {
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName());
                return Void.TYPE.newInstance();
            }).collect(Collectors.toList());

        singleThreadExecutors(mock);
        fixedThreadExecutors(mock);
        cachedExecutors(mock);
    }

    private static void singleThreadExecutors(List<Callable<Void>> callables) {
        new StudySingleThreadExecutor().allConsume(callables);
    }

    private static void fixedThreadExecutors(List<Callable<Void>> callables) {
        new StudyFixedThreadExecutor().allConsume(callables);
    }

    private static void cachedExecutors(List<Callable<Void>> callables) {
        new StudyCachedExecutor().allConsume(callables);
    }
}
