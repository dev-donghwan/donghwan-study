package com.donghwan.study.spring.companyasync.config;

import com.donghwan.study.spring.companyasync.second.SecondTaskManager;
import com.donghwan.study.spring.companyasync.first.task.module.FirstTaskExecutor;
import com.donghwan.study.spring.companyasync.first.task.module.InitTaskExecutor;
import com.donghwan.study.spring.companyasync.first.task.module.SecondTaskExecutor;
import com.donghwan.study.spring.companyasync.first.task.module.SendResultTaskExecutor;
import com.donghwan.study.spring.companyasync.first.FirstAsyncTaskManager;
import com.donghwan.study.spring.companyasync.first.dto.TaskType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {

    @Bean
    public FirstAsyncTaskManager firstTaskManager() {
        FirstAsyncTaskManager firstAsyncTaskManager = new FirstAsyncTaskManager();
        firstAsyncTaskManager.addAsyncTaskExecutor(TaskType.INIT, new InitTaskExecutor(5));
        firstAsyncTaskManager.addAsyncTaskExecutor(TaskType.FIRST, new FirstTaskExecutor(5));
        firstAsyncTaskManager.addAsyncTaskExecutor(TaskType.SECOND, new SecondTaskExecutor(5));
        firstAsyncTaskManager.addAsyncTaskExecutor(TaskType.SEND_RESULT, new SendResultTaskExecutor(5));
        return firstAsyncTaskManager;
    }

    @Bean
    public SecondTaskManager taskManager() {
        return new SecondTaskManager();
    }
}
