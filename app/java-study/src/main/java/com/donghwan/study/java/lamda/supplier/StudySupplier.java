package com.donghwan.study.java.lamda.supplier;

import com.donghwan.study.java.lamda.IStudy;
import java.util.function.Supplier;

public class StudySupplier implements IStudy {

    @Override
    public void start() {
        Supplier<String> supplier1 = () -> "donghwan supplier study";
        System.out.println(supplier1.get());

        Supplier<String> supplier2 = () -> new String("donghwan");
        System.out.println(supplier2.get());

        Supplier<String> supplier3 = String::new;
        System.out.println(supplier3.get());
    }
}
