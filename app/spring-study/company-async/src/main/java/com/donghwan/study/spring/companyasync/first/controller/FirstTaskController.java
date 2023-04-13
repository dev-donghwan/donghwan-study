package com.donghwan.study.spring.companyasync.first.controller;

import com.donghwan.study.spring.companyasync.first.FirstAsyncTaskManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FirstTaskController {

    private final FirstAsyncTaskManager manager;

    @PostMapping("/api/v1/first-data")
    public void insertData(@RequestBody Object input) {
        manager.insert(input);
    }
}
