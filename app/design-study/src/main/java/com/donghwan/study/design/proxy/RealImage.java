package com.donghwan.study.design.proxy;

public class RealImage implements Image {

    private final String fileName;

    private boolean isLoad = false;

    public RealImage(String fileName) {
        System.out.println("RealImage Constructor...");
        this.fileName = fileName;
        loadImage();
    }

    private void loadImage() {
        System.out.println("RealImage loadImage...");
        if (this.fileName == null || this.fileName.isEmpty()) {
            throw new RuntimeException("fileName not valid");
        }

        System.out.println("loading " + fileName + "...");
        this.isLoad = true;
    }

    @Override
    public void displayImage() {
        System.out.println("RealImage displayImage...");
        System.out.println("display " + fileName + "...");
    }
}
