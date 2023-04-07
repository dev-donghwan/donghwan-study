package com.donghwan.study.spring.basic.redis.repository;

import com.donghwan.study.spring.basic.redis.repository.entity.Sample;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RedisRepositoryController {

    private static int cnt = 0;

    private final RedisRepository repository;

    @PostMapping("/api/v1/redis-repository")
    public void insert() {
        String content = "Content" + ++cnt;
        Sample sample = Sample.of(content);
        repository.save(sample);
    }

    @GetMapping("/api/v1/redis-repository")
    public List<Sample> findAll() {
        List<Sample> result = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(result::add);
        return result;
    }
}
