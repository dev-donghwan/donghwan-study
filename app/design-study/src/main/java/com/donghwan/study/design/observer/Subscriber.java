package com.donghwan.study.design.observer;

public class Subscriber implements Observer {

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void notify(String message) {
        String form = String.format("%s [수신자 : %s]", message, this.name);
        System.out.println(form);
    }
}
