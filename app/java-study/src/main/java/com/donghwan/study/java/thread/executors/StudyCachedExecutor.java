package com.donghwan.study.java.thread.executors;

import java.util.concurrent.Executors;

public class StudyCachedExecutor extends AbstractStudyExecutorService {

    public StudyCachedExecutor() {
        super(Executors.newCachedThreadPool());
    }
}
