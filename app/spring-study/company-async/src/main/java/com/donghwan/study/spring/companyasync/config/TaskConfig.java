package com.donghwan.study.spring.companyasync.config;

import com.donghwan.study.spring.companyasync.second.SecondTaskManager;
import com.donghwan.study.spring.companyasync.first.task.module.FirstTask;
import com.donghwan.study.spring.companyasync.first.task.module.InitTask;
import com.donghwan.study.spring.companyasync.first.task.module.SecondTask;
import com.donghwan.study.spring.companyasync.first.task.module.SendResultTask;
import com.donghwan.study.spring.companyasync.first.FirstTaskManager;
import com.donghwan.study.spring.companyasync.first.dto.TaskType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {

    @Bean
    public FirstTaskManager firstTaskManager() {
        FirstTaskManager firstTaskManager = new FirstTaskManager();
        firstTaskManager.addTask(TaskType.INIT, new InitTask());
        firstTaskManager.addTask(TaskType.FIRST, new FirstTask());
        firstTaskManager.addTask(TaskType.SECOND, new SecondTask());
        firstTaskManager.addTask(TaskType.SEND_RESULT, new SendResultTask());
        return firstTaskManager;
    }

    @Bean
    public SecondTaskManager taskManager() {
        return new SecondTaskManager();
    }
}
