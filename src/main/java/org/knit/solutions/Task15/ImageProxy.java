package org.knit.solutions.Task15;

import java.util.HashMap;
import java.util.Map;

public class ImageProxy implements Image {
    private final String fileName;
    private static final Map<String, RealImage> imageCache = new HashMap<>();

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        RealImage realImage = imageCache.get(fileName);
        if (realImage == null) {
            realImage = new RealImage(fileName);
            imageCache.put(fileName, realImage);
        }
        realImage.display();
    }
}
