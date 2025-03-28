package org.knit.solutions.task15;

public class ImageProxy implements Image{
    private final String filename;
    private RealImage realImage;

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        System.out.println("Прокси передает запрос...");
        realImage.display();
    }
}
