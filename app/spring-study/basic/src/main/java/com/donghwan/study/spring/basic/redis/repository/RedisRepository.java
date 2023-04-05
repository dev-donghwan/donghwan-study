package com.donghwan.study.spring.basic.redis.repository;

import com.donghwan.study.spring.basic.redis.entity.Sample;
import org.springframework.data.repository.CrudRepository;

public interface RedisRepository extends CrudRepository<Sample, String> {
}
