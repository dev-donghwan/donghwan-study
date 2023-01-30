package com.donghwan.study.java.lamda.function;

import com.donghwan.study.java.lamda.IStudy;
import java.util.function.Function;

public class StudyFunction implements IStudy {

    @Override
    public void start() {
        Function<String, String> function1 = (input) -> input + " function study";
        System.out.println(function1.apply("donghwan!!"));

        Function<String, Integer> function2 = (input) -> input.length();
        System.out.println(function2.apply("donghwan"));

        Function<String, Integer> function3 = String::length;
        System.out.println(function3.apply("donghwan"));
    }
}
