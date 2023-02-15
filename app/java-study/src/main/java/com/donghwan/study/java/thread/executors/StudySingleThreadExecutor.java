package com.donghwan.study.java.thread.executors;

import java.util.concurrent.Executors;

public class StudySingleThreadExecutor extends AbstractStudyExecutorService {

    public StudySingleThreadExecutor() {
        super(Executors.newSingleThreadExecutor());
    }
}
