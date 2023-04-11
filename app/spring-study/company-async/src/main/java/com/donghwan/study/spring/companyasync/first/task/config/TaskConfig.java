package com.donghwan.study.spring.companyasync.first.task.config;

import com.donghwan.study.spring.companyasync.first.task.module.FirstTask;
import com.donghwan.study.spring.companyasync.first.task.module.InitTask;
import com.donghwan.study.spring.companyasync.first.task.module.SecondTask;
import com.donghwan.study.spring.companyasync.first.task.module.SendResultTask;
import com.donghwan.study.spring.companyasync.first.task.manager.TaskManager;
import com.donghwan.study.spring.companyasync.first.dto.TaskType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {

    @Bean
    public TaskManager taskManager() {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask(TaskType.INIT, new InitTask());
        taskManager.addTask(TaskType.FIRST, new FirstTask());
        taskManager.addTask(TaskType.SECOND, new SecondTask());
        taskManager.addTask(TaskType.SEND_RESULT, new SendResultTask());
        return taskManager;
    }
}
