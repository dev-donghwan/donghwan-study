package com.donghwan.study.spring.companyasync.second;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SecondTaskController {

    private final SecondTaskManager manager;

    @PostMapping("/api/v1/second-data")
    public void data(@RequestBody Object input) {
        manager.enqueue(input);
    }
}
