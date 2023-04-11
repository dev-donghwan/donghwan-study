package com.donghwan.study.spring.companyasync.first.task.manager;

import com.donghwan.study.spring.companyasync.first.dto.TaskDto;
import com.donghwan.study.spring.companyasync.first.dto.TaskType;
import com.donghwan.study.spring.companyasync.first.task.module.AbstractTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Slf4j
public class TaskManager {

    private final Map<TaskType, AbstractTask> tasks = new HashMap<>();

    private final Queue<TaskDto> taskQueue = new ConcurrentLinkedQueue<>();

    public void addTask(TaskType type, AbstractTask task) {
        tasks.put(type, task);
    }

    public void input(Object data) {
        log.info("start mills : {}", System.currentTimeMillis());
        this.enqueue(TaskDto.of(data));
    }

    private void enqueue(TaskDto dto) {
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
    }

    @Scheduled(fixedDelay = 1000)
    private void consume() {
        while (!taskQueue.isEmpty()) {
            TaskDto dto = taskQueue.poll();
            TaskType type = dto.getType();

            AbstractTask task = tasks.get(type);
            task.processing(dto, result -> Arrays.stream(result).forEach(this::enqueue));
        }
    }
}
