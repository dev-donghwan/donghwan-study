package com.donghwan.study.spring.companyasync.second;

import com.donghwan.study.spring.companyasync.first.dto.TaskDto;
import com.donghwan.study.spring.companyasync.first.dto.TaskType;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
public class SecondTaskManager {

    private final Executor inputWorkers = Executors.newSingleThreadExecutor();

    private final Executor logicWorkers = Executors.newCachedThreadPool();

    public void enqueue(Object data) {
        inputWorkers.execute(() -> enqueue(TaskDto.of(data)));
    }

    private void enqueue(TaskDto dto) {
        logicWorkers.execute(new Runnable() {
            @Override
            public void run() {
                log.info("{} {} start mills : {}", getClass().getSimpleName(), Thread.currentThread().getName(), System.currentTimeMillis());
                CompletableFuture.supplyAsync(() -> {
                    log.info("{} init {}", getClass().getSimpleName(), Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    TaskDto result = TaskDto.of(TaskType.FIRST, dto);
                    return new TaskDto[]{result, result, result, result, result, result};
                }).thenApplyAsync(dto1 -> {
                    log.info("{} first {}", getClass().getSimpleName(), Thread.currentThread().getName());
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    TaskDto result = TaskDto.of(TaskType.SECOND, dto1);
                    return new TaskDto[]{result, result, result, result};
                }).thenApplyAsync(dto2 -> {
                    log.info("{} second {}", getClass().getSimpleName(), Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return TaskDto.of(TaskType.SEND_RESULT, dto2);
                }).thenApplyAsync(dto3 -> {
                    log.info("{} result {}", getClass().getSimpleName(), Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    log.info("this input is processing complete : {}", System.currentTimeMillis());
                    return TaskDto.of(TaskType.COMPLETE, dto3);
                }).exceptionally(e -> {
                    throw new RuntimeException(e);
                }).join();

            }
        });
    }
}
