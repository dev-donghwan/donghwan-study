package com.donghwan.study.java.thread.basic;

import com.donghwan.study.java.thread.basic.extend.StudyThread;
import com.donghwan.study.java.thread.basic.imple.StudyRunnable;
import java.util.ArrayList;

public class BasicThreadMain {

    public static void main(String[] args) {
        System.out.println("main " + Thread.currentThread().getName() + " start");

        sample1();
        sample2();

    }

    private static void sample1() {
        //Runnable
        Runnable runnable = new StudyRunnable();
        new Thread(runnable).start();

        //Thread
        Thread thread = new StudyThread();
        thread.start();
    }

    private static void sample2() {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " start");
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " end");
            });
            thread.setName("no." + i);
            thread.start();
            threads.add(thread);
        }

        threads.forEach(thread -> {
            try {
                System.out.println(thread.getName() + " join start");
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(thread.getName() + " join end");
        });

        System.out.println("main " + Thread.currentThread().getName() + " end");
    }
}
