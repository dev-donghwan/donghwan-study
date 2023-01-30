package com.donghwan.study.java.lamda;

import com.donghwan.study.java.lamda.consumer.StudyConsumer;
import com.donghwan.study.java.lamda.custom.StudyCustomFunctional;
import com.donghwan.study.java.lamda.function.StudyFunction;
import com.donghwan.study.java.lamda.predicate.StudyPredicate;
import com.donghwan.study.java.lamda.supplier.StudySupplier;
import java.util.List;

public class AppMain {

    public static void main(String[] args) {
        List<IStudy> studyClazzList = List.of(
            new StudySupplier(),
            new StudyConsumer(),
            new StudyFunction(),
            new StudyPredicate(),
            new StudyCustomFunctional()
        );

        studyClazzList.forEach((studyClazzInstance) -> {
            String line = "==========" + studyClazzInstance.getClass().getSimpleName() + "==========";
            System.out.println(line);
            studyClazzInstance.start();
            System.out.println(line);
        });
    }
}
