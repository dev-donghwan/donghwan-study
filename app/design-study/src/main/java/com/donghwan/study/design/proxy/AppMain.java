package com.donghwan.study.design.proxy;

public class AppMain {

    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");

        image1.displayImage();
    }
}
