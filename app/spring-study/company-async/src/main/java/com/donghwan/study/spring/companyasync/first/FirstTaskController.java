package com.donghwan.study.spring.companyasync.first;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FirstTaskController {

    private final FirstTaskManager manager;

    @PostMapping("/api/v1/first-data")
    public void data(@RequestBody Object input) {
        manager.input(input);
    }
}
