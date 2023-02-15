package com.donghwan.study.spring.filter.log.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class LogResponseDto {

    private String name;

    private int age;

    public static LogResponseDto from(LogRequestDto dto) {
        return new LogResponseDto(dto.getName(), dto.getAge());
    }
}
