package com.donghwan.study.spring.companyasync.first.task.module;

import com.donghwan.study.spring.companyasync.first.task.TaskCallback;
import com.donghwan.study.spring.companyasync.first.dto.TaskType;
import com.donghwan.study.spring.companyasync.first.dto.TaskDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InitTask extends AbstractTask {

    @Override
    public void processing(TaskDto dto, TaskCallback callback) {
        executor.execute(() -> {
            log.info("{} {}", getClass().getSimpleName(), Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            TaskDto result = TaskDto.of(TaskType.FIRST, dto);
            callback.onEvent(result, result, result, result, result, result);
        });
    }
}
