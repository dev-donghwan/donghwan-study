package com.donghwan.study.design.observer;

public interface Subject {

    void registerObserver(Observer observer);

    void unRegisterObserver(Observer observer);

    void notify(String message);
}
