package com.donghwan.study.spring.companyasync.first.task;

import com.donghwan.study.spring.companyasync.first.task.manager.TaskManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TaskController {

    private final TaskManager manager;

    @PostMapping("/api/v1/first-data")
    public void data(@RequestBody Object input) {
        manager.input(input);
    }
}
