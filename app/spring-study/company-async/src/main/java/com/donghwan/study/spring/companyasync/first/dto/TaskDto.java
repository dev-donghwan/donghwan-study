package com.donghwan.study.spring.companyasync.first.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskDto {

    private TaskType type;

    private Object data;

    public static TaskDto of(Object data) {
        return new TaskDto(TaskType.INIT, data);
    }

    public static TaskDto of(TaskType type, Object data) {
        return new TaskDto(type, data);
    }

    public static TaskDto of(TaskType type, TaskDto dto) {
        return new TaskDto(type, dto.getData());
    }
}
