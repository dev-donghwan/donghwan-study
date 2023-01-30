package com.donghwan.study.java.lamda.custom;

import com.donghwan.study.java.lamda.IStudy;

public class StudyCustomFunctional implements IStudy {

    @Override
    public void start() {
        CustomFunctional<String> customFunctional = (input) -> input + " donghwan's Custom Lamda";
        System.out.println(customFunctional.formatting("developer"));
    }
}
