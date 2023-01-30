package com.donghwan.study.java.lamda.consumer;

import com.donghwan.study.java.lamda.IStudy;
import java.util.function.Consumer;

public class StudyConsumer implements IStudy {

    @Override
    public void start() {
        Consumer<String> consumer1 = (input) -> System.out.println(input);
        consumer1.accept("donghwan");

        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("donghwan");
    }
}
