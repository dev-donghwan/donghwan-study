package com.donghwan.study.spring.basic.redis.template;

import com.donghwan.study.spring.basic.redis.template.entity.Sample;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class RedisTemplateListController {

    private final String KEY = "list";

    private static int cnt = 0;

    private final RedisTemplate<String, Object> redisTemplate;


    @PostMapping("/api/v1/redis-template/list-push/left")
    public void left_insert() {
        Sample sample = Sample.of(++cnt + "", "Content" + cnt);
        getOperation().leftPush(KEY, sample);
    }

    @PostMapping("/api/v1/redis-template/list-push/right")
    public void right_insert() {
        ListOperations<String, Object> operations = redisTemplate.opsForList();
        operations.rightPush(KEY, createNewSample());
    }

    @GetMapping("/api/v1/redis-template/list")
    public Object findAll() {
        return redisTemplate.opsForList().range(KEY, 0, -1);
    }

    private <K, V> ListOperations<K, V> getOperation() {
        return (ListOperations<K, V>) redisTemplate.opsForList();
    }

    private Sample createNewSample() {
        return Sample.of(++cnt + "", "Content" + cnt);
    }
}
