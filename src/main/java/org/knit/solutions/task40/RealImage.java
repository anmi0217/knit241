package org.knit.solutions.task40;

public class RealImage implements Image {
    @Override
    public void request() {
        System.out.println("Запрос загрузки изображения с сервера.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Изображение загружено с сервера.");
    }
}
