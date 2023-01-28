package com.donghwan.study.design.observer;

import java.util.ArrayList;
import java.util.List;

public class Youtuber implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    private String channelName;

    public Youtuber(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unRegisterObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notify(String message) {
        String form = String.format("[%s]의 %s", channelName, message);
        observers.forEach(observer -> observer.notify(form));
    }
}
