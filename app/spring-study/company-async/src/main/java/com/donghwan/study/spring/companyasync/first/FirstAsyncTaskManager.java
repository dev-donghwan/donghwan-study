package com.donghwan.study.spring.companyasync.first;

import com.donghwan.study.spring.companyasync.first.dto.TaskDto;
import com.donghwan.study.spring.companyasync.first.dto.TaskType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FirstAsyncTaskManager extends AbstractAsyncTaskManager {

    public void insert(Object data) {
        this.enqueue(TaskDto.of(TaskType.INIT, data));
    }
}
