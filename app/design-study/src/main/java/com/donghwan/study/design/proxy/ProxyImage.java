package com.donghwan.study.design.proxy;

public class ProxyImage implements Image {

    private final String fileName;

    private RealImage realImage;

    public ProxyImage(String fileName) {

        System.out.println("ProxyImage Constructor...");
        this.fileName = fileName;
    }

    @Override
    public void displayImage() {
        System.out.println("ProxyImage displayImage...");
        if (realImage == null) {
            this.realImage = new RealImage(fileName);
        }

        this.realImage.displayImage();
    }
}
