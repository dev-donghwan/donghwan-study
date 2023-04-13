package com.donghwan.study.spring.companyasync.first.task.module;

import com.donghwan.study.spring.companyasync.first.dto.TaskDto;
import com.donghwan.study.spring.companyasync.first.dto.TaskType;
import com.donghwan.study.spring.companyasync.first.task.TaskCallback;
import com.donghwan.study.spring.companyasync.first.task.utils.SleepUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SendResultTaskExecutor extends AbstractTaskExecutor {

    public SendResultTaskExecutor(int threadCnt) {
        super(threadCnt);
    }

    @Override
    public void doTask(TaskDto dto, TaskCallback callback) {
        addNewTask(() -> {
            log.info("{} {}", getClass().getSimpleName(), Thread.currentThread().getName());
            SleepUtils.sleep(500);
            TaskDto result = TaskDto.of(TaskType.COMPLETE, dto);
            callback.onEvent(result);
        });
    }
}
