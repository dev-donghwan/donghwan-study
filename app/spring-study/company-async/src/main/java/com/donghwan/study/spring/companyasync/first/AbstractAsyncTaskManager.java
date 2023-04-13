package com.donghwan.study.spring.companyasync.first;

import com.donghwan.study.spring.companyasync.first.dto.TaskDto;
import com.donghwan.study.spring.companyasync.first.dto.TaskType;
import com.donghwan.study.spring.companyasync.first.task.module.AbstractTaskExecutor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
@Getter
public class AbstractAsyncTaskManager {

    private final Map<TaskType, AbstractTaskExecutor> taskExecutors = new HashMap<>();

    private final Executor executor = Executors.newSingleThreadExecutor();

    private final Queue<TaskDto> taskQueue = new ConcurrentLinkedQueue<>();

    public void addAsyncTaskExecutor(TaskType type, AbstractTaskExecutor task) {
        taskExecutors.put(type, task);
    }

    protected void enqueue(TaskDto dto) {
        executor.execute(() -> {
            log.info("{} {} start mills : {}", getClass().getSimpleName(), Thread.currentThread().getName(), System.currentTimeMillis());

            TaskType type = dto.getType();

            if (type == null || !TaskType.isContains(type)) {
                log.warn("type error : {}", type);
                return;
            }

            if (type == TaskType.COMPLETE) {
                log.info("this input is processing complete : {}", System.currentTimeMillis());
                return;
            }

            taskQueue.add(dto);
        });
    }

    @Scheduled(fixedDelay = 1000)
    private void consume() {
        while (!taskQueue.isEmpty()) {
            TaskDto dto = taskQueue.poll();
            TaskType type = dto.getType();

            AbstractTaskExecutor task = taskExecutors.get(type);
            task.doTask(dto, result -> Arrays.stream(result).forEach(this::enqueue));
        }
    }
}
