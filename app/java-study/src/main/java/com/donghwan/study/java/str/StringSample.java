package com.donghwan.study.java.str;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringSample {

    public static List<String> strings = IntStream.range(1, 500)
        .boxed()
        .map(String::valueOf)
        .collect(Collectors.toList());

    public StringSample() {
        this.stringBuilder();
        this.string();
    }

    public void string() {
        long startTime = System.nanoTime();
        String result = "";
        for (String string : strings) {
            result += string;
        }
        long endTime = System.nanoTime();
        System.out.println("String time : " + (endTime - startTime) + "ns");
    }

    public void stringBuilder() {
        long startTime = System.nanoTime();
        StringBuilder result = new StringBuilder();
        for (String string : strings) {
            result.append(string);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder time : " + (endTime - startTime) + "ns");
    }

    public static void main(String[] args) {
        new StringSample();
    }
}
