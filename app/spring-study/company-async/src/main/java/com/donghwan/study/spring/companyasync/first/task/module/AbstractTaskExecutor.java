package com.donghwan.study.spring.companyasync.first.task.module;

import com.donghwan.study.spring.companyasync.first.dto.TaskDto;
import com.donghwan.study.spring.companyasync.first.task.TaskCallback;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class AbstractTaskExecutor {

    private Executor executor;

    public AbstractTaskExecutor(int threadCnt) {
        this.executor = Executors.newFixedThreadPool(threadCnt);
    }

    abstract public void doTask(TaskDto dto, TaskCallback callback);

    protected void addNewTask(Runnable runnable) {
        executor.execute(runnable);
    }
}
