package com.donghwan.study.java.thread.executors;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

public abstract class AbstractStudyExecutorService {

    protected ExecutorService executorService = null;

    public AbstractStudyExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public <T> void allConsume(Collection<? extends Callable<T>> callables) {
        try {
            long startMills = System.currentTimeMillis();
            this.executorService.invokeAll(callables);
            long endMills = System.currentTimeMillis();
            System.out.println("running... " + (endMills - startMills) + "(ms)");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
