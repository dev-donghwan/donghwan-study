package com.donghwan.study.spring.basic.redis.repository.entity;

import java.io.Serializable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@RedisHash("sample")
public class Sample implements Serializable {

    @Id
    private String id;

    private String content;

    public static Sample of(String content) {
        return new Sample(null, content);
    }
}
