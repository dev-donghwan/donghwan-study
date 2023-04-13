package com.donghwan.study.spring.companyasync.first.task.utils;

public class SleepUtils {

    public static void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
