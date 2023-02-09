package com.donghwan.study.java.thread.extend;

public class StudyThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("StudyThread " + Thread.currentThread().getName() + " start");
            Thread.sleep(1_000L);
            System.out.println("StudyThread " + Thread.currentThread().getName() + " end");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
