package com.donghwan.study.spring.companyasync.first.dto;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum TaskType {

    INIT,
    FIRST,
    SECOND,
    SEND_RESULT,
    COMPLETE;

    public static boolean isContains(TaskType type) {
        return Arrays.stream(values()).anyMatch(taskType -> taskType == type);
    }
}
