package com.donghwan.study.spring.companyasync.first.task.module;

import com.donghwan.study.spring.companyasync.first.task.TaskCallback;
import com.donghwan.study.spring.companyasync.first.dto.TaskDto;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public abstract class AbstractTask {

    protected Executor executor = Executors.newCachedThreadPool();

    abstract public void processing(TaskDto dto, TaskCallback callback);

}
