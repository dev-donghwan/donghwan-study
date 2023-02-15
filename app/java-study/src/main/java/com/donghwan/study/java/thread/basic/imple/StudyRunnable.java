package com.donghwan.study.java.thread.basic.imple;

public class StudyRunnable implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("StudyRunnable " + Thread.currentThread().getName() + " start");
            Thread.sleep(1_000L);
            System.out.println("StudyRunnable " + Thread.currentThread().getName() + " end");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
