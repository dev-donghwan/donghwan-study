package com.donghwan.study.java.lamda.predicate;

import com.donghwan.study.java.lamda.IStudy;
import java.util.Objects;
import java.util.function.Predicate;

public class StudyPredicate implements IStudy {

    @Override
    public void start() {
        Predicate<String> predicate1 = (input) -> Objects.isNull(input);
        System.out.println(predicate1.test("donghwan"));

        Predicate<String> predicate2 = Objects::isNull;
        System.out.println(predicate2.test("donghwan"));
    }
}
