package org.knit.solutions.org2.lab15;

import java.util.HashMap;
import java.util.Map;

class ImageProxy implements Image {
    private String filename;
    private RealImage realImage;
    private static Map<String, RealImage> cache = new HashMap<>();

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            // Проверяем кэш перед загрузкой
            if (cache.containsKey(filename)) {
                realImage = cache.get(filename);
                System.out.println("Изображение " + filename + " взято из кэша");
            } else {
                realImage = new RealImage(filename);
                cache.put(filename, realImage);
            }
        }
        realImage.display();
    }
}