package org.knit.solutions.task40;

public class ImageProxy implements Image {
    private RealImage realImage;

    @Override
    public void request() {
        if (realImage == null) {
            realImage = new RealImage();
            System.out.println("Прокси передаёт запрос серверу.");
            realImage.request();
        } else {
            System.out.println("Изображение загружено из кэша.");
        }
    }
}
