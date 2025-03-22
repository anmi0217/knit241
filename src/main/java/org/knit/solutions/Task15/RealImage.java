package org.knit.solutions.Task15;

public class RealImage implements Image {
    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Загрузка изображения " + fileName + " с сервера...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Изображение " + fileName + " загружено.");
    }

    @Override
    public void display() {
        System.out.println("Отображение изображения " + fileName);
    }
}
