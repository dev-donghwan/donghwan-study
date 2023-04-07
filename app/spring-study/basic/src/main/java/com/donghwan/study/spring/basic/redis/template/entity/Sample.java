package com.donghwan.study.spring.basic.redis.template.entity;

import java.io.Serializable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Sample implements Serializable {

    private String id;
    private String content;

    public static Sample of(String id, String content) {
        return new Sample(id, content);
    }
}
