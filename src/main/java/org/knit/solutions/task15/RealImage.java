package org.knit.solutions.task15;

public class RealImage implements Image{
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromServer();
    }

    private void loadFromServer(){
        System.out.println("Загрузка с сервера: " + filename);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        System.out.println("Изображение: " + filename);
    }
}
