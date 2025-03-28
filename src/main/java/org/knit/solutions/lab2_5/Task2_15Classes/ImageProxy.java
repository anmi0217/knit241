package org.knit.solutions.lab2_5.Task2_15Classes;

public class ImageProxy implements ImageSubject{
    private RealImage image;

    @Override
    public void request() throws InterruptedException {
        if (image == null) {
            image = new RealImage();
        }
        image.request();
    }
}
