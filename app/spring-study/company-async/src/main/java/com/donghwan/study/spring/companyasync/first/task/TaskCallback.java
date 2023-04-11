package com.donghwan.study.spring.companyasync.first.task;

import com.donghwan.study.spring.companyasync.first.dto.TaskDto;

public interface TaskCallback {

    // 가변인자? List?
    void onEvent(TaskDto... result);
}
