package com.donghwan.study.spring.basic.redis.template;

import com.donghwan.study.spring.basic.redis.template.entity.Sample;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RedisTemplateSetController {

    private final String KEY = "set";

    private static int cnt = 0;

    private final RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/api/v1/redis-template/set/add")
    public void a() {
        getOperation().add(KEY, createNewSample());
    }

    @GetMapping("/api/v1/redis-template/set")
    public Object b() {
        return getOperation().members(KEY);
    }

    private <K, V> SetOperations<K, V> getOperation() {
        return (SetOperations<K, V>) redisTemplate.opsForSet();
    }

    private Sample createNewSample() {
        return Sample.of(++cnt + "", "Content" + cnt);
    }
}
