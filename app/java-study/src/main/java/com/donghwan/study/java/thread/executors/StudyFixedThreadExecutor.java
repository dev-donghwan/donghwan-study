package com.donghwan.study.java.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StudyFixedThreadExecutor extends AbstractStudyExecutorService {

    public StudyFixedThreadExecutor() {
        super(Executors.newFixedThreadPool(3));
    }
}
